package com.lazy.system.auth.controller;

import com.lazy.common.core.domain.R;
import com.lazy.system.api.auth.model.dto.AuthDto;
import com.lazy.system.api.auth.model.vo.AccountVo;
import com.lazy.system.auth.service.IAccountService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 账号表 前端控制器
 * </p>
 *
 * @author ywx
 * @since 2024-09-25
 */
@RestController
@RequestMapping("/sys/account")
@RequiredArgsConstructor
public class AccountController {

    private final @NonNull IAccountService accountService;

    @GetMapping("query/{loginName}")
    public R<AccountVo> queryAuth(@PathVariable("loginName") String loginName) {
        return accountService.queryAuth(loginName);
    }

    @PostMapping("add")
    public R<String> add(@RequestBody AuthDto authDto) {
        return accountService.addUser(authDto);
    }

}
