package com.faep.action;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faep.common.enums.ResultVO;
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
    public String addNewConfig(@RequestBody FrameConfig config) {
        if (StringUtils.isEmpty(config.getDomain()) || StringUtils.isEmpty(config.getKeyname())
                || StringUtils.isEmpty(config.getValue())) {
            return "参数配置不能为空！";
        }

        FrameConfig dbRet = frameConfigService.findFrameConfigByKey(config.getKeyname());
        if (dbRet != null && dbRet.getDomain().equals(config.getDomain())) {
            return "重复新增，参数已存在！";
        }

        config.setRowguid(UUID.randomUUID().toString());
        frameConfigService.addNewFrameConfig(config);
        return ResultVO.SUCCESS.getValue();
    }

    @PostMapping("/findall")
    List<FrameConfig> findAllFrameConfig(@RequestBody FrameConfig config) {
        if (StringUtils.isEmpty(config.getKeyname())) {
            return frameConfigService.findAllFrameConfig();
        }
        return frameConfigService.findFrameConfigsLikeKeyName(config.getKeyname());
    }

    @PostMapping("/updateconfig")
    public String updateFrameConfig(@RequestBody FrameConfig config) {
        frameConfigService.updateFrameConfig(config);
        return ResultVO.SUCCESS.getValue();
    }

    @PostMapping("/findbykey")
    public FrameConfig findFrameConfigByKey(@RequestBody FrameConfig config) {
        return frameConfigService.findFrameConfigByKey(config.getKeyname());
    }

}
