package com.lazy.system.role.service.impl;

import com.lazy.system.api.role.model.entity.UserRole;
import com.lazy.system.role.mapper.UserRoleMapper;
import com.lazy.system.role.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author ywx
 * @since 2024-10-28
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
