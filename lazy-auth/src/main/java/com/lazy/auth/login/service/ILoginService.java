package com.lazy.auth.login.service;

import com.lazy.common.core.utils.R;
import com.lazy.system.api.login.dto.LoginDto;

public interface ILoginService {
    R doLogin(LoginDto loginDto);

    R queryCode();

}
