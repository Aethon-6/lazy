package com.lazy.common.satoken.utils;

import cn.dev33.satoken.stp.StpUtil;
import com.lazy.common.core.domain.vo.UserVo;

/**
 * @author : yangwx
 * @description :
 * @createDate : 2024/10/15
 */
public class CacheHelper {
    public static Long currentUserId() {
        return currentUser().getId();
    }

    public static UserVo currentUser() {
        return (UserVo) StpUtil.getSession().get("user");
    }
}
