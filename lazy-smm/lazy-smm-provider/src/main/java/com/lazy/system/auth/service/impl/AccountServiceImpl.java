package com.lazy.system.auth.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lazy.common.core.domain.R;
import com.lazy.common.core.utils.CryptoKit;
import com.lazy.common.core.utils.StrKit;
import com.lazy.system.api.auth.model.dto.AuthDto;
import com.lazy.system.api.auth.model.entity.Account;
import com.lazy.system.api.auth.model.vo.AccountVo;
import com.lazy.common.core.domain.vo.UserVo;
import com.lazy.system.auth.mapper.AccountMapper;
import com.lazy.system.auth.service.IAccountService;
import com.lazy.system.config.CipherConfig;
import com.lazy.system.user.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import com.lazy.system.api.user.model.entity.User;

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

    @Resource
    private CipherConfig cipherConfig;

    @Resource
    private IUserService userService;

    @Override
    public R<AccountVo> queryAuth(String loginName) {
        Account account = getOne(
                lambdaQuery().getWrapper()
                        .eq(Account::getLoginname, loginName)
        );

        UserVo userVo = new UserVo();
        if (ObjectUtil.isNotNull(account) && ObjectUtil.isNotNull(account.getUserId())) {
            LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(User::getId, account.getUserId());
            User user = userService.getOne(wrapper);
            userVo = UserVo.builder()
                    .id(user.getId())
                    .userName(user.getUserName())
                    .userAge(user.getUserAge())
                    .userGender(user.getUserGender())
                    .build();
        }
        AccountVo accountVo = new AccountVo();
        if (ObjectUtil.isNotNull(account)) {
            accountVo = AccountVo.builder()
                    .id(account.getId())
                    .userId(account.getUserId())
                    .loginname(account.getLoginname())
                    .password(account.getPassword())
                    .user(userVo)
                    .build();
        }
        return R.ok(accountVo);
    }

    @Override
    public R<String> addUser(AuthDto authDto) {
        boolean flag = save(Account.builder()
                .id(StrKit.uuid())
                .userId(authDto.getUserId())
                .loginname(authDto.getLoginName())
                .password(CryptoKit.Md5.encrypt(cipherConfig.getDefaultPWD()))
                .build());

        return flag ? R.ok("新增成功！") : R.fail();
    }
}
