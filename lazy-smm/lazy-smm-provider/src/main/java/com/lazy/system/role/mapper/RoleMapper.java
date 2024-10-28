package com.lazy.system.role.mapper;

import com.lazy.system.api.role.model.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author ywx
 * @since 2024-10-28
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

}
