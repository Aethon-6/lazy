package com.lazy.common.core.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;

public class StrKit extends StrUtil {
    public static Long numUuid() {
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        return snowflake.nextId();
    }
}
