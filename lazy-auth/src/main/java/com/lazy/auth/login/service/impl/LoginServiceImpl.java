package com.lazy.auth.login.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.lazy.auth.login.service.ILoginService;
import com.lazy.common.core.domain.R;
import com.lazy.common.core.domain.model.LoginUser;
import com.lazy.common.core.domain.vo.LoginVo;
import com.lazy.common.satoken.utils.LoginHelper;
import com.lazy.system.api.auth.feign.RemoteAuthService;
import com.lazy.system.api.auth.model.vo.AccountVo;
import com.lazy.system.api.login.model.dto.LoginDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements ILoginService {

    @Resource
    private RemoteAuthService remoteAuthService;

    @Override
    public R<LoginVo> doLogin(LoginDto loginDto) {
        AccountVo account = remoteAuthService.queryAuth(loginDto.getLoginname()).getData();
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
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(100, 40, 6, 20);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("img", captcha.getImageBase64Data());
        return R.ok(map);
    }

    @Override
    public R<String> loginOut() {
        LoginHelper.loginOut();
        return R.ok("注销成功！");
    }
}
