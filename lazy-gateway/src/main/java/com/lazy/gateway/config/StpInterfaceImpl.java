package com.lazy.gateway.config;

import cn.dev33.satoken.stp.StpInterface;
import com.lazy.system.entity.Permission;
import com.lazy.system.entity.Role;
import com.lazy.system.feign.RemotePermissionService;
import com.lazy.system.feign.RemoteRoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StpInterfaceImpl implements StpInterface {
    @Resource
    private RemotePermissionService permissionService;

    @Resource
    private RemoteRoleService roleService;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 返回此 loginId 拥有的权限列表
        List<String> strs = new ArrayList<>();
        List<Permission> list = (ArrayList<Permission>) permissionService.queryInfoByUserId((Long) loginId).getData().get("permissions");
        list.forEach(p -> {
            strs.add(p.getPermissionCode());
        });
        return strs;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 返回此 loginId 拥有的角色列表
        List<String> strs = new ArrayList<>();
        List<Role> list = (ArrayList<Role>) roleService.queryInfoByUserId((Long) loginId).getData().get("roles");
        list.forEach(r -> {
            strs.add(r.getRoleCode());
        });
        return strs;
    }
}
