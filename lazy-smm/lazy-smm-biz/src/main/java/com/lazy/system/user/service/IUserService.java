package com.lazy.system.user.service;

import com.lazy.common.core.utils.R;
import com.lazy.system.dto.UserInfo;
import com.lazy.system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ywx
 * @since 2023-08-26
 */
public interface IUserService extends IService<User> {

    UserInfo info(Long loginId);
}
