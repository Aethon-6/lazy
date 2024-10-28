package com.lazy.system.permission.mapper;

import com.lazy.system.api.permission.model.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author ywx
 * @since 2024-10-28
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}
