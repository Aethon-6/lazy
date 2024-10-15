package com.lazy.auth.login.service;

import com.lazy.common.core.domain.R;
import com.lazy.common.core.domain.vo.LoginVo;
import com.lazy.system.api.login.model.dto.LoginDto;

import java.util.Map;

public interface ILoginService {
    R<LoginVo> doLogin(LoginDto loginDto);

    R<Map<String, Object>> queryCode();

}
