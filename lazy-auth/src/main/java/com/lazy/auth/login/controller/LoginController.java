package com.lazy.auth.login.controller;

import com.lazy.auth.login.service.ILoginService;
import com.lazy.common.core.domain.R;
import com.lazy.common.core.domain.vo.LoginVo;
import com.lazy.system.api.login.model.dto.LoginDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class LoginController {

    private final @NonNull ILoginService loginService;

    @PostMapping("login")
    public R<LoginVo> doLogin(@RequestBody LoginDto loginDto) {
        return loginService.doLogin(loginDto);
    }

    @GetMapping("query/code")
    public R<Map<String, Object>> queryCode() {
        return loginService.queryCode();
    }

    @PostMapping("logout")
    public R<String> loginOut() {
        return loginService.loginOut();
    }
}
