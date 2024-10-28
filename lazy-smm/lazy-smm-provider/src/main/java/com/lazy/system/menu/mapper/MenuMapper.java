package com.lazy.system.menu.mapper;

import com.lazy.system.api.menu.model.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author ywx
 * @since 2024-10-28
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

}
