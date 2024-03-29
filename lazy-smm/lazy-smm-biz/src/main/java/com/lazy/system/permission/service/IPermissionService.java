package com.lazy.system.permission.service;

import com.lazy.system.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author ywx
 * @since 2024-02-21
 */
public interface IPermissionService extends IService<Permission> {
    List<Permission> queryPermissionsByUserId(Long userId);
}
