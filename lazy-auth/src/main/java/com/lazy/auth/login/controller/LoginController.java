package com.lazy.auth.login.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.lazy.auth.login.service.ILoginService;
import com.lazy.common.core.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author codersoft
 */

@RestController
@RequestMapping("auth/login")
public class LoginController {

    @Resource
    private ILoginService loginService;

    /**
     * 登录
     *
     * @return
     */
    @PostMapping
    public R login(@RequestBody Map<String, Object> param) {
        return loginService.login(param);
    }

    /**
     * 验证码
     *
     * @return
     */
    @GetMapping("code")
    public R code() {
        return loginService.code();
    }
}
