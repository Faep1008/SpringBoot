package com.faep.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faep.entity.LoginRecord;
import com.faep.service.api.ILoginRecordService;

/**
 * 描述： 登录历史记录Controller
 * 作者： Faep
 * 创建时间： 2020-11-03 15:19
 * 版本： [1.0, 2020-11-03]
 * 版权： Faep
 */
@RestController
@RequestMapping("/loginrecord")
public class LoginRecordController
{

    @Autowired
    ILoginRecordService loginRecordService;

    /**
     * 获取用户下的登录记录
     * 
     * @param request
     * @return
     */
    @PostMapping("/finduserrecord")
    public List<LoginRecord> findLoginRecord(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userguid = (String) session.getAttribute("userguid");
        if (StringUtils.isEmpty(userguid)) {
            return new ArrayList<>();
        }
        List<LoginRecord> allRecordByUser = loginRecordService.findAllRecordByUser(userguid);
        int i = 1;
        for (LoginRecord loginRecord : allRecordByUser) {
            loginRecord.setRemark(String.valueOf(i++));
            loginRecord.setLoginmac(DateFormatUtils.format(loginRecord.getLogindate(), "yyyy-MM-dd HH:mm:ss"));
        }
        if(allRecordByUser.size() > 10){
            allRecordByUser = allRecordByUser.subList(0, 10);
        }
        return allRecordByUser;
    }

}
