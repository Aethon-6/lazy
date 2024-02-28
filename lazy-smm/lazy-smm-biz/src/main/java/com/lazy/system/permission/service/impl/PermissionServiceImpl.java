package com.lazy.system.permission.service.impl;

import com.lazy.system.entity.Permission;
import com.lazy.system.permission.mapper.PermissionMapper;
import com.lazy.system.permission.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author ywx
 * @since 2024-02-21
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Override
    public List<Permission> getPermissionByUserId(Long userId) {
        return getPermissionByUserId(userId);
    }
}
