package com.lazy.system.permission.service.impl;

import com.lazy.system.api.permission.model.entity.Permission;
import com.lazy.system.permission.mapper.PermissionMapper;
import com.lazy.system.permission.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author ywx
 * @since 2024-10-28
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
