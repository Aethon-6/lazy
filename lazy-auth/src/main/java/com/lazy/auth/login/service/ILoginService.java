package com.lazy.auth.login.service;

import com.lazy.common.core.utils.R;

import java.util.Map;

public interface ILoginService {
    R login(Map<String, Object> param);

    R code();
}
