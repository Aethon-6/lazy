package com.lazy.system.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lazy.common.core.domain.R;
import com.lazy.system.api.user.model.dto.UserDto;
import com.lazy.system.api.user.model.dto.UserRequestDto;
import com.lazy.system.api.user.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lazy.system.api.user.model.vo.UserInfoVo;

import java.util.List;

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

    R<Page<User>> queryUserList(UserRequestDto userRequestDto);

    R<UserInfoVo> queryCurrentUser();
}
