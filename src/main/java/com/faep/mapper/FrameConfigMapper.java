package com.faep.mapper;

import com.faep.entity.FrameConfig;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 描述： 系统参数Mapper
 * 作者： Faep
 * 创建时间： 2020-11-04 09:27
 * 版本： [1.0, 2020-11-04]
 * 版权： Faep
 */
@Mapper
public interface FrameConfigMapper {

    /**
     * 新增系统参数配置
     * @param config
     * @return
     */
    @Insert("insert into FrameConfig values (#{rowguid},#{domain},#{keyname},#{value},#{remark})")
    int addNewFrameConfig(FrameConfig config);

    @Select("select * from FrameConfig order by domain,keyname")
    List<FrameConfig> findAllFrameConfig();

    @Select("select * from FrameConfig where domain=#{domain} order by keyname")
    List<FrameConfig> findAllFrameConfigByDomain(String domain);

    /**
     * 更新
     * @param config
     * @return
     */
    @Update("update FrameConfig set value=#{value},remark=#{remark} where domain=#{domain} and keyname=#{keyname}")
    int updateFrameConfig(FrameConfig config);

    @Select("select * from FrameConfig where keyname=#{keyname}")
    FrameConfig findFrameConfigByKey(String keyname);

    @Select("select * from FrameConfig where keyname like concat('%',#{keyname},'%') order by keyname")
    List<FrameConfig> findFrameConfigsLikeKeyName(String keyname);
}
