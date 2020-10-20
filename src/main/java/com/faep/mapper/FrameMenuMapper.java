package com.faep.mapper;

import com.faep.entity.FrameMenu;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 描述： 系统菜单Mapper
 * 作者： Faep
 * 创建时间： 2020-10-20 15:08
 * 版本： [1.0, 2020-10-20]
 * 版权： Faep
 */
@Mapper
public interface FrameMenuMapper
{

    /**
     * 新增一个菜单
     * 
     * @param menu
     * @return
     */
    @Insert("insert into FrameMenu values (#{rowguid}, #{menuname}, #{menuurl}, #{menuorder}, #{parentguid}, #{enabled}, #{roles}, #{menutype}, #{remark})")
    int addNewFrameMenu(FrameMenu menu);

    /**
     * 更新一个菜单
     */
    @Update("update FrameMenu set menuname=#{menuname}, menuurl=#{menuurl}, menuorder=#{menuorder}, parentguid=#{parentguid},enabled=#{enabled}, roles=#{roles}, menutype=#{menutype}, remark=#{remark} where rowguid=#{rowguid}")
    int updateFrameMenu(FrameMenu menu);

    /**
     * 删除一个菜单
     * @param rowguid
     * @return
     */
    @Delete("delete from FrameMenu where rowguid=#{rowguid}")
    int deleteFrameMenu(String rowguid);

    /**
     * 获取所有菜单
     * @return
     */
    @Select("select * from FrameMenu")
    List<FrameMenu> findAllFrameMenu();

}
