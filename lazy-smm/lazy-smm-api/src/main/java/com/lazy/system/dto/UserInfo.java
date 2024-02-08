package com.lazy.system.dto;

import com.lazy.system.entity.Account;
import com.lazy.system.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {
    /**
     * 用户信息
     */
    private User user;
    /**
     * 账号信息
     */
    private Account account;

    /**
     * 权限标识集合
     */
    private String[] permissions;

    /**
     * 角色集合
     */
    private Long[] roles;
}
