package com.lazy.auth.login.controller;

import com.lazy.auth.login.service.ILoginService;
import com.lazy.common.core.utils.R;
import com.lazy.system.api.login.dto.LoginDto;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class LoginController {

    @Resource
    private ILoginService loginService;

    @PostMapping("login")
    public R doLogin(@RequestBody LoginDto loginDto) {
        return loginService.doLogin(loginDto);
    }

    @GetMapping("query/code")
    public R queryCode() {
        return loginService.queryCode();
    }
}
