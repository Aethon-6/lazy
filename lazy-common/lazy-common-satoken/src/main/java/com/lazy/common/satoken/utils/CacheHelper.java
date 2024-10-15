package com.lazy.common.satoken.utils;

import cn.dev33.satoken.stp.StpUtil;

/**
 * @author : yangwx
 * @description :
 * @createDate : 2024/10/15
 */
public class CacheHelper {
    public static String currentUserId() {
        return StpUtil.getSession().getString("userId");
    }
}
