package com.lazy.system.api.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : yangwx
 * @description :
 * @createDate : 2024/10/15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String userName;
    private Integer userAge;
    private String userGender;
}
