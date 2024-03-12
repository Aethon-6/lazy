package com.lazy.system.role.controller;

import com.lazy.common.core.utils.R;
import com.lazy.system.role.service.IRoleService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author ywx
 * @since 2024-02-28
 */
@RestController
@RequestMapping("/role/role")
public class RoleController {
    @Resource
    private IRoleService roleService;

    @GetMapping("info/query/{userId}")
    public R queryInfoByUserId(@PathVariable("userId") Long userId) {
        return R.success().data("roles", roleService.queryRolesByUserId(userId));
    }
}
