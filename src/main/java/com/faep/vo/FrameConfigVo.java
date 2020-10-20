package com.faep.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 描述： 系统参数配置
 * 作者： Faep
 * 创建时间： 2020-10-20 16:23
 * 版本： [1.0, 2020-10-20]
 * 版权： Faep
 */
@Component
@ConfigurationProperties(prefix = "frame.config", ignoreInvalidFields = true)
public class FrameConfigVo
{

    /**
     * 无需判断登录就可访问的资源后缀
     */
    private String skipFilterSuffix;

    /**
     * 无需登录就可访问的页面
     */
    private String noNeedAuthPages;

    /**
     * 不需要登录就能访问的action方法
     */
    private String noNeedAuthActions;

    public String getSkipFilterSuffix() {
        return skipFilterSuffix;
    }

    public void setSkipFilterSuffix(String skipFilterSuffix) {
        this.skipFilterSuffix = skipFilterSuffix;
    }

    public String getNoNeedAuthPages() {
        return noNeedAuthPages;
    }

    public void setNoNeedAuthPages(String noNeedAuthPages) {
        this.noNeedAuthPages = noNeedAuthPages;
    }

    public String getNoNeedAuthActions() {
        return noNeedAuthActions;
    }

    public void setNoNeedAuthActions(String noNeedAuthActions) {
        this.noNeedAuthActions = noNeedAuthActions;
    }
}
