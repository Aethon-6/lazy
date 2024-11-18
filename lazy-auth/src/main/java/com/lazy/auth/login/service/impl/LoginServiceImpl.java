package com.lazy.auth.login.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.lazy.auth.login.service.ILoginService;
import com.lazy.common.core.domain.R;
import com.lazy.common.core.domain.model.LoginUser;
import com.lazy.common.core.domain.vo.LoginVo;
import com.lazy.common.core.utils.StrKit;
import com.lazy.common.redis.utils.RedisUtil;
import com.lazy.common.satoken.utils.LoginHelper;
import com.lazy.system.api.auth.feign.RemoteAuthService;
import com.lazy.system.api.auth.model.vo.AccountVo;
import com.lazy.system.api.login.model.dto.LoginDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements ILoginService {

    private static final String LOGIN_CODE_KEY = "login:code:";

    @Resource
    private RemoteAuthService remoteAuthService;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public R<LoginVo> doLogin(LoginDto loginDto) {
        if (redisUtil.get(LOGIN_CODE_KEY + loginDto.getValidateCodeKey()) == null) {
            return R.fail("验证码已过期！");
        }
        if (!StrKit.equals(redisUtil.get(LOGIN_CODE_KEY + loginDto.getValidateCodeKey()).toLowerCase(), loginDto.getCode().toLowerCase())) {
            return R.fail("验证码不正确！");
        }
        redisUtil.delete(LOGIN_CODE_KEY + loginDto.getValidateCodeKey());
        AccountVo account = remoteAuthService.queryAuth(loginDto.getLoginName()).getData();
        if (ObjectUtil.isNull(account)) {
            return R.fail("账号不存在！");
        }

        if (!StrUtil.equals(loginDto.getPassword(), account.getPassword())) {
            return R.fail("账号或密码不正确！");
        }
        LoginVo loginVo = LoginHelper.login(LoginUser.builder()
                .userId(account.getId())
                .userLogin(account.getLoginname())
                .user(account.getUser())
                .build());


        return R.ok(loginVo);
    }

    @Override
    public R<Map<String, Object>> queryCode() {
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(100, 40, 4, 20);
        Map<String, Object> map = new LinkedHashMap<>();
        String uuid = StrKit.numUuid() + "";
        String validateCodeKey = LOGIN_CODE_KEY + uuid;
        redisUtil.set(validateCodeKey, captcha.getCode(), 5, TimeUnit.MINUTES);
        map.put("validateCodeKey", uuid);
        map.put("img", captcha.getImageBase64Data());
        return R.ok(map);
    }

    @Override
    public R<String> loginOut() {
        LoginHelper.loginOut();
        return R.ok("注销成功！");
    }
}
