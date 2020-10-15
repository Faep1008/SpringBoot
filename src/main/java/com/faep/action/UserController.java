package com.faep.action;

import com.alibaba.fastjson.JSON;
import com.faep.entity.User;
import com.faep.service.api.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
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

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String aduser(){
        User user = new User();
        user.setRowguid(UUID.randomUUID().toString());
        user.setUsername("fxp");
        user.setLoginid("fxp");
        user.setPassword("11111");
        user.setLastlogintime(new Date());
        user.setPhone("17777777777");
        user.setEnabled("1");
        userService.addNewUser(user);

        logger.info(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "-接口被调用");
        return "新增用户成功！";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User user){
//        String userName = request.getParameter("username");
//        String password = request.getParameter("password");
        if(StringUtils.isEmpty(user.getLoginid())){
            return "登录名不能为空！";
        }
        if(StringUtils.isEmpty(user.getPassword())){
            return "密码不能为空！";
        }
        System.out.println("登录用户：" + user.getLoginid() + "," + user.getPassword());
        if("11111".equals(user.getPassword())){
            return "OK";
        }
        return "用户名或密码错误，登录失败！";
    }

    /**
     * 获取所有的用户数据
     * @return
     */
    @RequestMapping(value = "/findalluser", method = RequestMethod.POST)
    public List<User> findAllUsers(){
        List<User> users = userService.findAllUsers();
        String json = JSON.toJSONString(users);
        System.out.println("用户信息：" + json);
        return users;
    }

}
