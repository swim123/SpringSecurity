package com.ryx.service;

import com.ryx.entity.Menu;
import com.ryx.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @BelongsPackage: com.ryx.service
 * @Author: 容永轩
 * @CreateTime: 2021-07-05
 * @Description:
 */
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public List<Menu> getAllMenus(){
        return menuMapper.getAllMenus();
    }
}
