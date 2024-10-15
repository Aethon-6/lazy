package com.lazy.common.core.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

public class StrKit {
    public static Long uuid() {
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        return snowflake.nextId();
    }
}
