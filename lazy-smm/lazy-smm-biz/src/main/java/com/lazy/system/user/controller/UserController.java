package com.lazy.system.user.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.json.JSONUtil;
import com.lazy.common.core.utils.R;
import com.lazy.system.dto.UserInfo;
import com.lazy.system.user.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ywx
 * @since 2023-08-26
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {
    @Resource
    private IUserService userService;

    @GetMapping("info/by/name")
    public R getUserInfoByUserName(@RequestParam String username) {
        return userService.getUserInfoByUserName(username);
    }
    // docker run --name mysql -v /srv/docker/mysql/log:/var/log/mysql -v /srv/docker/mysql/data:/var/lib/mysql -v /srv/docker/mysql/conf:/etc/mysql/conf.d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=111111 -itd mysql

    @GetMapping("info")
    public R getUserInfo() {
        Long loginId = NumberUtil.binaryToLong(StpUtil.getLoginId().toString());
        UserInfo userInfo = userService.info(loginId);
        Map<String, Object> map = new HashMap<>();
        map.put("username", userInfo.getUser().getUserName());
        map.put("roles", userInfo.getRoles());
        return R.success().data(map);
    }

    @GetMapping("info/{userId}")
    public R getUserInfoById(@PathVariable(value = "userId") Long userId) {
        UserInfo userInfo = userService.info(userId);
        return R.success().data("userinfo", userInfo);
    }
}
