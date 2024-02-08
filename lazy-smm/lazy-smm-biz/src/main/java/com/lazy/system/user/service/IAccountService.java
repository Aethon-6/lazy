package com.lazy.system.user.service;

import com.lazy.system.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 账号表 服务类
 * </p>
 *
 * @author ywx
 * @since 2023-08-26
 */
public interface IAccountService extends IService<Account> {

    Account queryInfo(String username);

    Account queryInfoByUserId(Long userId);
}
