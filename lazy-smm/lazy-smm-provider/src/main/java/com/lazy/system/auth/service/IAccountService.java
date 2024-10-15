package com.lazy.system.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lazy.common.core.domain.R;
import com.lazy.system.api.auth.model.entity.Account;

/**
 * <p>
 * 账号表 服务类
 * </p>
 *
 * @author ywx
 * @since 2024-09-25
 */
public interface IAccountService extends IService<Account> {

    R<Account> queryAuth(String loginname);
}
