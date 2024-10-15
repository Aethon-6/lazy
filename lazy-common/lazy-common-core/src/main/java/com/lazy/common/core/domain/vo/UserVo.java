package com.lazy.common.core.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    private Long id;
    private String userName;
    private Integer userAge;
    private String userGender;
}
