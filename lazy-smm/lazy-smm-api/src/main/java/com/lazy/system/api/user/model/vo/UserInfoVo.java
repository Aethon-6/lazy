package com.lazy.system.api.user.model.vo;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Builder
@Getter
@Setter
public class UserInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String userName;
    private Integer userAge;
    private String userGender;
}
