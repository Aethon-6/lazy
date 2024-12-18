package com.lazy.system.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lazy.common.core.domain.R;
import com.lazy.common.core.utils.StrKit;
import com.lazy.common.satoken.utils.CacheHelper;
import com.lazy.system.api.user.model.dto.UserDto;
import com.lazy.system.api.user.model.dto.UserRequestDto;
import com.lazy.system.api.user.model.entity.User;
import com.lazy.system.api.user.model.vo.UserInfoVo;
import com.lazy.system.user.mapper.UserMapper;
import com.lazy.system.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ywx
 * @since 2024-10-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public R<String> addUser(UserDto user) {
        boolean flag = save(User.builder()
                .id(StrKit.uuid())
                .userName(user.getUserName())
                .userAge(user.getUserAge())
                .userGender(user.getUserGender())
                .build());
        return flag ? R.ok("新增成功！") : R.fail();
    }

    @Override
    public R<Page<User>> queryUserList(UserRequestDto userRequestDto) {
        Page<User> page = new Page<>(userRequestDto.getPageNum(), userRequestDto.getPageSize());
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if (StrKit.isNotBlank(userRequestDto.getUserName())) {
            wrapper.like(User::getUserName, userRequestDto.getUserName());
        }
        Page<User> userPage = page(page, wrapper);

        return R.ok(userPage);
    }

    @Override
    public R<UserInfoVo> queryCurrentUser() {
        String userId = CacheHelper.currentUserId();
        User user = getOne(new LambdaQueryWrapper<User>().eq(User::getId, userId));
        UserInfoVo userVo = UserInfoVo.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .userAge(user.getUserAge())
                .userGender(user.getUserGender())
                .build();
        return R.ok(userVo);
    }
}
