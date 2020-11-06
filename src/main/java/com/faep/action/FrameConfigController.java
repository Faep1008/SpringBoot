package com.faep.action;

import java.util.List;
import java.util.UUID;

import com.faep.common.enums.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faep.entity.FrameConfig;
import com.faep.service.api.IFrameConfigService;

/**
 * 描述： 系统参数后台
 * 作者： Faep
 * 创建时间： 2020-11-04 10:09
 * 版本： [1.0, 2020-11-04]
 * 版权： Faep
 */
@RestController
@RequestMapping("/frameconfig")
public class FrameConfigController
{

    @Autowired
    IFrameConfigService frameConfigService;

    @PostMapping("/add")
    public String addNewConfig(FrameConfig config) {
        config.setRowguid(UUID.randomUUID().toString());
        frameConfigService.addNewFrameConfig(config);
        return ResultVO.成功.getValue();
    }

    @PostMapping("/findall")
    List<FrameConfig> findAllFrameConfig() {
        return frameConfigService.findAllFrameConfig();
    }

    @PostMapping("/updateconfig")
    public String updateFrameConfig(FrameConfig config) {
        frameConfigService.updateFrameConfig(config);
        return ResultVO.成功.getValue();
    }

    @PostMapping("/findbykey")
    public FrameConfig findFrameConfigByKey(String keyname) {
        return frameConfigService.findFrameConfigByKey(keyname);
    }

}
