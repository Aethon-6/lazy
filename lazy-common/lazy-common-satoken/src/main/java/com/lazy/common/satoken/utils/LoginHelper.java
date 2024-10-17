package com.lazy.common.satoken.utils;

import cn.dev33.satoken.stp.StpUtil;
import com.lazy.common.core.domain.model.LoginUser;
import com.lazy.common.core.domain.vo.LoginVo;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoginHelper {

    public static LoginVo login(LoginUser loginUser) {
        StpUtil.login(loginUser.getUserId());
        StpUtil.getSession().set("user", loginUser.getUser());
        return LoginVo.builder()
                .accessToken(StpUtil.getTokenValue())
                .build();
    }

}