package com.lazy.common.mybatis.config;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.lazy.common.core.constant.CommonConstants;
import com.lazy.common.satoken.utils.CacheHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.nio.charset.Charset;
import java.time.LocalDateTime;

@Slf4j
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.debug("mybatis plus start insert fill ....");
        LocalDateTime now = LocalDateTime.now();

        fillValIfNullByName("createTime", now, metaObject, true);
        fillValIfNullByName("updateTime", now, metaObject, true);
        fillValIfNullByName("createBy", CacheHelper.currentUserId(), metaObject, true);
        fillValIfNullByName("updateBy", CacheHelper.currentUserId(), metaObject, true);

        // 删除标记自动填充
        fillValIfNullByName("delFlag", CommonConstants.STATUS_NORMAL, metaObject, true);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.debug("mybatis plus start update fill ....");
        fillValIfNullByName("updateTime", LocalDateTime.now(), metaObject, true);
        fillValIfNullByName("updateBy", CacheHelper.currentUserId(), metaObject, true);
    }


    /**
     * 填充值，先判断是否有手动设置，优先手动设置的值，例如：job必须手动设置
     *
     * @param fieldName  属性名
     * @param fieldVal   属性值
     * @param metaObject MetaObject
     * @param isCover    是否覆盖原有值,避免更新操作手动入参
     */
    private static void fillValIfNullByName(String fieldName, Object fieldVal, MetaObject metaObject, boolean isCover) {
        // 0. 如果填充值为空
        if (fieldVal == null) {
            return;
        }
        // 1. 如果用户有手动设置的值
        Object userSetValue = metaObject.getValue(fieldName);
        String setValueStr = StrUtil.str(userSetValue, Charset.defaultCharset());
        if (StrUtil.isNotBlank(setValueStr) && !isCover) {
            return;
        }
        // 2. field 类型相同时设置
        Class<?> getterType = metaObject.getGetterType(fieldName);
        if (ClassUtils.isAssignableValue(getterType, fieldVal)) {
            metaObject.setValue(fieldName, fieldVal);
        }
    }

}
