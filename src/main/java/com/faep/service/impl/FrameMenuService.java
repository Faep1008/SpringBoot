package com.faep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faep.entity.FrameMenu;
import com.faep.mapper.FrameMenuMapper;
import com.faep.service.api.IFrameMenuService;

/**
 * 描述： 系统菜单Service实现类
 * 作者： Faep
 * 创建时间： 2020-10-20 15:25
 * 版本： [1.0, 2020-10-20]
 * 版权： Faep
 */
@Service
public class FrameMenuService implements IFrameMenuService
{

    @Autowired
    @SuppressWarnings("all")
    private FrameMenuMapper menuMapper;

    @Override
    public int addNewFrameMenu(FrameMenu menu) {
        return menuMapper.addNewFrameMenu(menu);
    }

    @Override
    public int updateFrameMenu(FrameMenu menu) {
        return menuMapper.updateFrameMenu(menu);
    }

    @Override
    public int deleteFrameMenu(String rowguid) {
        return menuMapper.deleteFrameMenu(rowguid);
    }

    @Override
    public List<FrameMenu> findAllFrameMenu() {
        return menuMapper.findAllFrameMenu();
    }
}
