package com.lazy.system.role.service;

import com.lazy.system.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author ywx
 * @since 2024-02-28
 */
public interface IRoleService extends IService<Role> {
    List<Role> queryRolesByUserId(Long userId);
}
