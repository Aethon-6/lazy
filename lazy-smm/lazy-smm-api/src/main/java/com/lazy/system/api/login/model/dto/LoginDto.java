package com.lazy.system.api.login.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    private String loginName;
    private String password;
    private String code;
    private String validateCodeKey;
}
