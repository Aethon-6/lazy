package com.lazy.auth.login.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.lazy.auth.login.service.ILoginService;
import com.lazy.common.core.utils.R;
import com.lazy.system.dto.UserInfo;
import com.lazy.system.entity.Account;
import com.lazy.system.feign.RemoteAccountService;
import com.lazy.system.feign.RemoteUserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class LoginServiceImpl implements ILoginService {
    @Resource
    private RemoteUserService remoteUserService;

    @Resource
    private RemoteAccountService remoteAccountService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public R login(Map<String, Object> param) {
        if (!StrUtil.equals("1", param.get("code").toString())) {
            log.info("验证码不正确！！！");
        }
        Account accountInfo = JSONUtil.toBean(JSONUtil.toJsonStr(remoteAccountService.queryInfo(param.get("username").toString()).getData().get("accountInfo")), Account.class);
        if (StrUtil.equals(param.get("password").toString(), accountInfo.getPassword())) {
            StpUtil.login(accountInfo.getUserId());
            UserInfo userinfo = JSONUtil.toBean(JSONUtil.toJsonStr(remoteUserService.queryInfoById(accountInfo.getUserId()).getData().get("userinfo")), UserInfo.class);
            StpUtil.getSession().set("userinfo", userinfo);
            return R.success().data("token", StpUtil.getTokenValue());
        }
        return R.error().data("message", "账号或密码错误");
    }

    @Override
    public R code() {
        // 创建验证码图片
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(100, 40, 6, 20);
        String key = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(key, captcha.getCode());
        Map<String, Object> map = new HashMap<>();
        map.put("key", key);
        map.put("img", captcha.getImageBase64Data());
        return R.success().data(map);
    }
}
