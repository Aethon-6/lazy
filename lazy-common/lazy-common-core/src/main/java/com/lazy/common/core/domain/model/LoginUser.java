package com.lazy.common.core.domain.model;

import com.lazy.common.core.domain.vo.UserVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser {
    public String userId;
    public String userLogin;
    public Long deptId;
    public String deptName;
    public UserVo user;
}
