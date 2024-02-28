package com.lazy.system.user.controller;

import com.lazy.common.core.utils.R;
import com.lazy.system.user.service.IAccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 账号表 前端控制器
 * </p>
 *
 * @author ywx
 * @since 2023-08-26
 */
@RestController
@RequestMapping("/sys/account")
public class AccountController {

    @Resource
    private IAccountService accountService;

    @GetMapping("info/query")
    public R info(@RequestParam String username) {
        return R.success().data("accountInfo", accountService.queryInfo(username));
    }

    @GetMapping("info/{userId}")
    R queryInfoByUserId(@PathVariable(value = "userId") Long userId) {
        return R.success().data("accountInfo", accountService.queryInfoByUserId(userId));
    }
}
