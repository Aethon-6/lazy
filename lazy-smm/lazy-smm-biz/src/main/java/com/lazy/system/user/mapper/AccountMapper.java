package com.lazy.system.user.mapper;

import com.lazy.system.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 账号表 Mapper 接口
 * </p>
 *
 * @author ywx
 * @since 2023-08-26
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

}
