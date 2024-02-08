package com.lazy.auth.login.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.lazy.common.core.utils.R;
import com.lazy.system.entity.Account;
import com.lazy.system.feign.RemoteUserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author codersoft
 */
@Slf4j
@RestController
@RequestMapping("auth/login")
public class LoginController {
    @Resource
    private RemoteUserService remoteUserService;

    /**
     * 登录
     *
     * @return
     */
    @PostMapping
    public R login(@RequestBody Map<String, Object> param) {
        if (!StrUtil.equals("1", param.get("code").toString())) {
            log.info("验证码不正确！！！");
        }
        Account accountInfo = JSONUtil.toBean(JSONUtil.toJsonStr(remoteUserService.getUserInfoByUserName(param.get("username").toString()).getData().get("accountInfo")), Account.class);
        if (StrUtil.equals(param.get("password").toString(), accountInfo.getPassword())) {
            StpUtil.login(accountInfo.getUserId());
            return R.success().data("token", StpUtil.getTokenValue());
        }
        return R.error().data("message", "账号或密码错误");
    }

    /**
     * 验证码
     *
     * @return
     */
    @GetMapping("code")
    public R code() {
        // 创建验证码图片
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(100, 40, 6, 20);
        return R.success().data("img", captcha.getImageBase64Data());
    }
}
