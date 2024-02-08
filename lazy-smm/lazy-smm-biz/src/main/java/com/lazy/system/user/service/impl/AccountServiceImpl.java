package com.lazy.system.user.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lazy.system.entity.Account;
import com.lazy.system.entity.User;
import com.lazy.system.user.mapper.AccountMapper;
import com.lazy.system.user.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账号表 服务实现类
 * </p>
 *
 * @author ywx
 * @since 2023-08-26
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

    @Override
    public Account queryInfo(String username) {
        return getOne(Wrappers.<Account>query()
                .lambda()
                .eq(StrUtil.isNotBlank(username), Account::getLoginname, username)
        );
    }

    @Override
    public Account queryInfoByUserId(Long userId) {
        return getOne(Wrappers.<Account>query()
                .lambda()
                .eq(Account::getUserId, userId)
        );
    }
}
