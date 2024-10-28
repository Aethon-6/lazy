package com.lazy.system.role.controller;

import com.lazy.common.core.domain.R;
import com.lazy.system.api.role.model.dto.RoleRequestDto;
import com.lazy.system.role.service.IRoleService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author ywx
 * @since 2024-10-28
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController {

    @Resource
    private IRoleService roleService;

    @PostMapping("add")
    public R<String> add(@RequestBody RoleRequestDto roleRequestDto) {
        return roleService.add(roleRequestDto);
    }

}
