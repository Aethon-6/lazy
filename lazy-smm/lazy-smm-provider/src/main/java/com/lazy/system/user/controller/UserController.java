package com.lazy.system.user.controller;

import com.lazy.common.core.domain.R;
import com.lazy.system.api.user.model.dto.UserDto;
import com.lazy.system.user.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ywx
 * @since 2024-10-15
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Resource
    private IUserService userService;

    @PostMapping("add")
    public R<String> addUser(@RequestBody UserDto user) {
        return userService.addUser(user);
    }
}
