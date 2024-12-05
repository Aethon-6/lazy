package com.lazy.system.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lazy.common.core.domain.R;
import com.lazy.system.api.user.model.dto.UserDto;
import com.lazy.system.api.user.model.dto.UserRequestDto;
import com.lazy.system.api.user.model.entity.User;
import com.lazy.system.api.user.model.vo.UserInfoVo;
import com.lazy.system.user.service.IUserService;
import jakarta.annotation.Resource;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@RequiredArgsConstructor
public class UserController {

    private final @NonNull IUserService userService;

    @PostMapping("add")
    public R<String> addUser(@RequestBody UserDto user) {
        return userService.addUser(user);
    }

    @GetMapping("list")
    public R<Page<User>> queryUserList(UserRequestDto userRequestDto) {
        return userService.queryUserList(userRequestDto);
    }

    @GetMapping("query")
    public R<UserInfoVo> queryCurrentUser() {
        return userService.queryCurrentUser();
    }
}
