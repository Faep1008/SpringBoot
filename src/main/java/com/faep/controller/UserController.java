package com.faep.controller;

import com.faep.entity.User;
import com.faep.service.api.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;


/**
 * 测试Controller
 * 作者： Faep
 * 创建时间： 2020/6/16 15:16
 * 版本： [1.0, 2020/6/16]
 * 版权： Faep
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/aduser", method = RequestMethod.GET)
    public String aduser(){
        User user = new User();
        user.setRowguid(UUID.randomUUID().toString());
        user.setUsername("Faep");
        user.setLoginid("Faep");
        user.setPassword("11111");
        user.setLastlogintime(new Date());
        user.setPhone("18888888888");
        user.setEnabled("1");
        userService.addNewUser(user);

        logger.info(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "-接口被调用");
        return "新增用户成功！";
    }

}
