package com.lazy.system.permission.controller;

import com.lazy.common.core.utils.R;
import com.lazy.system.permission.service.IPermissionService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author ywx
 * @since 2024-02-21
 */
@RestController
@RequestMapping("/sys/permission")
public class PermissionController {
    @Resource
    private IPermissionService permissionService;

    @GetMapping("info/query/{userId}")
    public R queryInfoByUserId(@PathVariable("userId") Long userId) {
        return R.success().data("permissions", permissionService.queryPermissionsByUserId(userId));
    }
}
