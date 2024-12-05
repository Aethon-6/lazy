package com.lazy.system.api.auth.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : yangwx
 * @description :
 * @createDate : 2024/12/5
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthDto {
    private String userId;
    private String loginName;
    private String password;
}
