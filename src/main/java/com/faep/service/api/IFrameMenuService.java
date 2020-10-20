package com.faep.service.api;

import java.util.List;

import com.faep.entity.FrameMenu;

/**
 * 描述： 系统菜单Service接口
 * 作者： Faep
 * 创建时间： 2020-10-20 15:24
 * 版本： [1.0, 2020-10-20]
 * 版权： Faep
 */
public interface IFrameMenuService
{
    /**
     * 新增一个菜单
     *
     * @param menu
     * @return
     */
    int addNewFrameMenu(FrameMenu menu);

    /**
     * 更新一个菜单
     */
    int updateFrameMenu(FrameMenu menu);

    /**
     * 删除一个菜单
     * 
     * @param rowguid
     * @return
     */
    int deleteFrameMenu(String rowguid);

    /**
     * 获取所有菜单
     * 
     * @return
     */
    List<FrameMenu> findAllFrameMenu();
}
