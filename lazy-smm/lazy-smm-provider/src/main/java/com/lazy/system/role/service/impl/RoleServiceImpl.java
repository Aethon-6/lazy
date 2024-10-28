package com.lazy.system.role.service.impl;

import com.lazy.common.core.domain.R;
import com.lazy.common.core.utils.StrKit;
import com.lazy.system.api.role.model.dto.RoleRequestDto;
import com.lazy.system.api.role.model.entity.Role;
import com.lazy.system.role.mapper.RoleMapper;
import com.lazy.system.role.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author ywx
 * @since 2024-10-28
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public R<String> add(RoleRequestDto roleRequestDto) {
        save(Role.builder()
                .id(StrKit.uuid())
                .roleName(roleRequestDto.getRoleName())
                .roleCode(roleRequestDto.getRoleCode())
                .roleDesc(roleRequestDto.getRoleDesc())
                .parentId(roleRequestDto.getParentId())
                .build());

        return R.ok("新增成功！");
    }
}
