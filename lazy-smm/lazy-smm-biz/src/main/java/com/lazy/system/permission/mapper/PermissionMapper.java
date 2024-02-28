package com.lazy.system.permission.mapper;

import com.lazy.system.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author ywx
 * @since 2024-02-21
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
    List<Permission> getPermissionByUserId(Long userId);
}
