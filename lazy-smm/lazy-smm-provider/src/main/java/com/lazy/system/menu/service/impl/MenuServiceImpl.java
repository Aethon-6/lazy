package com.lazy.system.menu.service.impl;

import com.lazy.system.api.menu.model.entity.Menu;
import com.lazy.system.menu.mapper.MenuMapper;
import com.lazy.system.menu.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author ywx
 * @since 2024-10-28
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
