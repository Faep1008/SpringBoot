package com.faep.action;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.faep.entity.User;
import com.faep.service.api.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 测试Controller
 * 作者： Faep
 * 创建时间： 2020/6/16 15:16
 * 版本： [1.0, 2020/6/16]
 * 版权： Faep
 */
@RestController
@RequestMapping("/user")
@Scope("request")
public class UserController
{

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    /**
     * 用户注册
     * 
     * @return
     */
    @PostMapping(value = "/adduser")
    public String adduser(@RequestBody User user) {
        user.setRowguid(UUID.randomUUID().toString());
        user.setRoles("admin");
//        user.setLastlogintime(null);
//        user.setLocked(null);
//        user.setRemark(null);
//        user.setOrdernum((int)(Math.random()*10000));
        userService.addNewUser(user);
        logger.info("新增用户成功！" + user.getUsername());
        return "OK";
    }

    /**
     * 用户登录
     * 
     * @param user
     * @return
     */
    @PostMapping(value = "/login")
    public String login(@RequestBody User user, HttpServletRequest request) {
        if (StringUtils.isEmpty(user.getLoginid())) {
            return "登录名不能为空！";
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            return "密码不能为空！";
        }
        User userDB = userService.findUserByLoginId(user.getLoginid());
        if (userDB == null) {
            logger.info(user.getLoginid() + " 无此用户！登录失败！");
            return "无此用户！请注册！";
        }
        if (userDB.getPassword().equals(user.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("username", userDB.getUsername());
            logger.info(user.getLoginid() + " 用户登录成功！");
            return "OK";
        }
        else {
            logger.info(user.getLoginid() + " 用户登录失败！");
            return "用户名或密码错误，请重试！";
        }
    }

    /**
     * 获取所有的用户数据
     * 
     * @return
     */
    @PostMapping(value = "/findAllUsers")
    public List<User> findAllUsers() {
        List<User> users = userService.findAllUsers();
        //logger.info("用户信息：" + JSON.toJSONString(users));
        logger.info("查询所有用户成功！");
        return users;
    }

    /**
     * 用户注销登录
     *
     * @return
     */
    @PostMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            logger.info(session.getAttribute("username") + " 用户注销！");
            session.setAttribute("username", null);
            session.invalidate();
            return "OK";
        }catch (Exception e){
            logger.error("用户注销失败！", e);
            return "Error";
        }
    }

    @PostMapping(value = "/getCurUser")
    public String getCurUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("username");
        if (StringUtils.isEmpty(userName)) {
            userName = "未登录";
        }
        return userName;
    }

}
