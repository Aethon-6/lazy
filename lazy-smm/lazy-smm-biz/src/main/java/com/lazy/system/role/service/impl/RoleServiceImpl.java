package com.lazy.system.role.service.impl;

import com.lazy.system.entity.Role;
import com.lazy.system.role.mapper.RoleMapper;
import com.lazy.system.role.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author ywx
 * @since 2024-02-28
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> queryRolesByUserId(Long userId) {
        return roleMapper.queryRolesByUserId(userId);
    }
}
