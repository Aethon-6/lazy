package com.lazy.system.api.auth.model.vo;

import com.lazy.common.core.domain.vo.UserVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountVo {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 账号
     */
    private String loginname;

    private String password;

    private UserVo user;
}
