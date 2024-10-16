package com.lazy.common.core.domain.dto;

import lombok.*;

/**
 * @author : yangwx
 * @description :
 * @createDate : 2024/10/16
 */
@Getter
@Setter
public class PaginationDto {
    private Integer pageNum;
    private Integer pageSize;
}
