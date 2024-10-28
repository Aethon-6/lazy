package com.lazy.system.role.service;

import com.lazy.common.core.domain.R;
import com.lazy.system.api.role.model.dto.RoleRequestDto;
import com.lazy.system.api.role.model.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author ywx
 * @since 2024-10-28
 */
public interface IRoleService extends IService<Role> {

    R<String> add(RoleRequestDto roleRequestDto);
}
