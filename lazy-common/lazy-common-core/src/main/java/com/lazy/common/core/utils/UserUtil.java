package com.lazy.common.core.utils;

import cn.dev33.satoken.stp.StpUtil;
import com.lazy.system.dto.UserInfo;
import com.lazy.system.entity.Account;
import com.lazy.system.entity.User;

import java.util.List;

public class UserUtil {

    public static User getUserInfo() {
        return ((UserInfo) StpUtil.getSession().get("userinfo")).getUser();
    }

    public static Account getAccountInfo() {
        return ((UserInfo) StpUtil.getSession().get("userinfo")).getAccount();
    }

    public static List<String> getPermissions() {
        return StpUtil.getPermissionList();
    }

    private static List<String> getRoles() {
        return StpUtil.getRoleList();
    }

}
