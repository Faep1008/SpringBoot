package com.faep.service.api;

import java.util.List;

import com.faep.entity.FrameConfig;

/**
 * 描述： 系统参数Service
 * 作者： Faep
 * 创建时间： 2020-11-04 09:34
 * 版本： [1.0, 2020-11-04]
 * 版权： Faep
 */
public interface IFrameConfigService
{
    /**
     * 新增系统参数配置
     * 
     * @param config
     * @return
     */
    int addNewFrameConfig(FrameConfig config);

    List<FrameConfig> findAllFrameConfig();

    List<FrameConfig> findAllFrameConfigByDomain(String domain);

    /**
     * 更新
     * 
     * @param config
     * @return
     */
    int updateFrameConfig(FrameConfig config);

    String findFrameConfigByKey(String keyname);
}
