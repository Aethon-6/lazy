package com.lazy.system.api.user.model.dto;

import com.lazy.common.core.domain.dto.PaginationDto;
import lombok.*;

/**
 * @author : yangwx
 * @description :
 * @createDate : 2024/10/16
 */
@Getter
@Setter
public class UserRequestDto extends PaginationDto {
    private String userName;
}
