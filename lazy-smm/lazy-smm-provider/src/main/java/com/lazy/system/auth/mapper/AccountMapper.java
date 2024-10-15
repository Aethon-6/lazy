package com.lazy.system.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lazy.system.api.auth.model.entity.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 账号表 Mapper 接口
 * </p>
 *
 * @author ywx
 * @since 2024-09-25
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

}
