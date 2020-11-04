package com.faep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faep.entity.FrameConfig;
import com.faep.mapper.FrameConfigMapper;
import com.faep.service.api.IFrameConfigService;

/**
 * 描述： 系统参数service实现类
 * 作者： Faep
 * 创建时间： 2020-11-04 09:35
 * 版本： [1.0, 2020-11-04]
 * 版权： Faep
 */
@Service
public class FrameConfigService implements IFrameConfigService
{

    @Autowired
    @SuppressWarnings("all")
    FrameConfigMapper frameConfigMapper;

    @Override
    public int addNewFrameConfig(FrameConfig config) {
        return frameConfigMapper.addNewFrameConfig(config);
    }

    @Override
    public List<FrameConfig> findAllFrameConfig() {
        return frameConfigMapper.findAllFrameConfig();
    }

    @Override
    public List<FrameConfig> findAllFrameConfigByDomain(String domain) {
        return frameConfigMapper.findAllFrameConfigByDomain(domain);
    }

    @Override
    public int updateFrameConfig(FrameConfig config) {
        return frameConfigMapper.updateFrameConfig(config);
    }

    @Override
    public String findFrameConfigByKey(String keyname) {
        return frameConfigMapper.findFrameConfigByKey(keyname);
    }
}
