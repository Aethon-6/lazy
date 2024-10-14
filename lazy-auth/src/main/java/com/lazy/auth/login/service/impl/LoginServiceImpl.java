package com.lazy.auth.login.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.lazy.auth.login.service.ILoginService;
import com.lazy.common.core.domain.R;
import com.lazy.common.core.domain.model.LoginUser;
import com.lazy.common.core.domain.vo.LoginVo;
import com.lazy.common.satoken.utils.LoginHelper;
import com.lazy.system.api.auth.entity.Account;
import com.lazy.system.api.auth.feign.RemoteAuthService;
import com.lazy.system.api.login.dto.LoginDto;
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
        Account account = remoteAuthService.queryAuth(loginDto.getLoginname()).getData();
        if (ObjectUtil.isNull(account)) {
            return R.fail("账号不存在！");
        }

        if (!StrUtil.equals(loginDto.getPassword(), account.getPassword())) {
            return R.fail("账号或密码不正确！");
        }
        LoginVo loginVo = LoginHelper.login(LoginUser.builder()
                .userId(account.getId())
                .username(account.getLoginname())
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
}
