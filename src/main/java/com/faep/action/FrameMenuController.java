package com.faep.action;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faep.entity.FrameMenu;
import com.faep.service.api.IFrameMenuService;

/**
 * 描述： 系统菜单Controller
 * 作者： Faep
 * 创建时间： 2020-10-20 15:24
 * 版本： [1.0, 2020-10-20]
 * 版权： Faep
 */
@RestController
@RequestMapping("/menu")
@Scope("request")
public class FrameMenuController
{
    @Autowired
    private IFrameMenuService frameMenuService;

    /**
     * 新增一个菜单
     * 
     * @param menu
     */
    @PostMapping("/addMenu")
    public void addNewMenu(@RequestBody FrameMenu menu) {
        menu.setRowguid(UUID.randomUUID().toString());
        frameMenuService.addNewFrameMenu(menu);
    }

    /**
     * 获取所有菜单
     * @return
     */
    @PostMapping("/findAllMenus")
    public List<FrameMenu> findAllMenus(){
        return frameMenuService.findAllFrameMenu();
    }

}
