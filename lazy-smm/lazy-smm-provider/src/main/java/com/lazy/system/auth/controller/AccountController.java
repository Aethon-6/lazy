package com.lazy.system.auth.controller;

import com.lazy.common.core.domain.R;
import com.lazy.system.api.auth.model.vo.AccountVo;
import com.lazy.system.auth.service.IAccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class AccountController {

    @Resource
    private IAccountService accountService;

    @GetMapping("query/{loginName}")
    public R<AccountVo> queryAuth(@PathVariable("loginName") String loginName) {
        return accountService.queryAuth(loginName);
    }

}
