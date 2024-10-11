package com.lazy.auth.login.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.lazy.auth.login.service.ILoginService;
import com.lazy.common.core.utils.R;
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
    public R doLogin(LoginDto loginDto) {
        R authR = remoteAuthService.queryAuth(loginDto.getLoginname());
        if (!authR.getSuccess()) {
            return R.error().message("账号不存在！");
        }
        Account account = BeanUtil.toBean(authR.getData().get("account"), Account.class);

        if (!StrUtil.equals(loginDto.getPassword(), account.getPassword())) {
            return R.error().message("账号或密码不正确！");
        }
        return R.success().data("auth", authR);
    }

    @Override
    public R queryCode() {
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(100, 40, 6, 20);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("img", captcha.getImageBase64Data());
        return R.success().data(map);
    }
}
