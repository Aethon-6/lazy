package com.lazy.system.user.service;

import com.lazy.common.core.domain.R;
import com.lazy.system.api.user.model.dto.UserDto;
import com.lazy.system.api.user.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ywx
 * @since 2024-10-15
 */
public interface IUserService extends IService<User> {

    R<String> addUser(UserDto user);
}
