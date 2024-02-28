package com.lazy.system.user.service.impl;

import cn.hutool.json.JSONUtil;
import com.lazy.common.core.utils.R;
import com.lazy.system.dto.UserInfo;
import com.lazy.system.entity.Account;
import com.lazy.system.entity.Permission;
import com.lazy.system.entity.User;
import com.lazy.system.feign.RemoteAccountService;
import com.lazy.system.permission.service.IPermissionService;
import com.lazy.system.user.mapper.UserMapper;
import com.lazy.system.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ywx
 * @since 2023-08-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private RemoteAccountService remoteAccountService;

    @Resource
    private IPermissionService permissionService;

    @Override
    public UserInfo info(Long loginId) {
        User user = getById(loginId);
        Account account = JSONUtil.toBean(JSONUtil.toJsonStr(remoteAccountService.queryInfoByUserId(loginId).getData().get("accountInfo")), Account.class);
        List<Permission> permissionList = permissionService.getPermissionByUserId(loginId);
        List<String> permissions = new ArrayList<>();
        permissionList.forEach(p -> {
            permissions.add(p.getPermissionCode());
        });
        return UserInfo.builder()
                .account(account)
                .permissions(permissions)
                .user(user)
                .build();
    }

}
