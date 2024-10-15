package com.lazy.system.auth.service.impl;

import com.lazy.common.core.domain.R;
import com.lazy.system.api.auth.model.entity.Account;
import com.lazy.system.auth.mapper.AccountMapper;
import com.lazy.system.auth.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账号表 服务实现类
 * </p>
 *
 * @author ywx
 * @since 2024-09-25
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

    @Override
    public R<Account> queryAuth(String loginname) {
        Account account = getOne(
                lambdaQuery().getWrapper()
                        .eq(Account::getLoginname, loginname)
        );
        return R.ok(account);
    }
}
