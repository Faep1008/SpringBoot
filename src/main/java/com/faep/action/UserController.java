package com.faep.action;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faep.entity.PhoneVerifyCode;
import com.faep.entity.User;
import com.faep.service.api.IPhoneVerifyCodeService;
import com.faep.service.api.ISmsService;
import com.faep.service.api.IUserService;

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
    @Autowired
    IPhoneVerifyCodeService phoneVerifyCodeService;
    @Autowired
    ISmsService smsService;

    private static String loginTemplateCode = "SMS_205130909";
    private static String registTemplateCode = "SMS_205120971";

    /**
     * 用户注册
     * 
     * @return
     */
    @PostMapping(value = "/adduser")
    public String adduser(@RequestBody User user) {
        user.setRowguid(UUID.randomUUID().toString());
        user.setLastlogintime(new Date());
        user.setOrdernum((int) (Math.random() * 10000));
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
            logger.info(user.getLoginid() + " 用户登录成功[账号密码]！");
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
        // logger.info("用户信息：" + JSON.toJSONString(users));
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
        }
        catch (Exception e) {
            logger.error("用户注销失败！", e);
            return "Error";
        }
    }

    /**
     * 获取当前用户
     * 
     * @param request
     * @return
     */
    @PostMapping(value = "/getCurUser")
    public String getCurUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("username");
        if (StringUtils.isEmpty(userName)) {
            userName = "未登录";
        }
        return userName;
    }

    /**
     * 验证码登录发送验证码
     * 
     * @return
     */
    @PostMapping(value = "/sendloginvcode")
    public String sendLoginVerifyCode(@RequestBody User user) {
        // 获取手机号
        String phone = user.getPhone();
        User userDB = userService.findUserByPhone(phone);
        PhoneVerifyCode verifyCode = phoneVerifyCodeService.findPhoneVerifyCode(phone);
        if (userDB == null) {
            return "无此用户，请先注册！";
        }

        // 判断是否可以生成验证码
        if (verifyCode != null
                && !smsService.isCanSendSms(verifyCode.getVerifycode(), verifyCode.getCodegeneratetime())) {
            return "验证码已发送，请勿重新发送！";
        }
        // 生成验证码
        String newCode = smsService.generateVerifyCode();
        // 发送
        String ret = smsService.sendSms(phone, newCode, loginTemplateCode);
        if ("OK".equals(ret)) {
            // 发送成功记录入库
            if (verifyCode == null) {
                verifyCode = new PhoneVerifyCode();
                verifyCode.setRowguid(UUID.randomUUID().toString());
                verifyCode.setPhone(phone);
                verifyCode.setVerifycode(newCode);
                verifyCode.setCodegeneratetime(new Date());
                phoneVerifyCodeService.addNewPhoneVerifyCode(verifyCode);
            }
            else {
                verifyCode.setVerifycode(newCode);
                verifyCode.setCodegeneratetime(new Date());
                phoneVerifyCodeService.updatePhoneVerifyCodeByPhone(verifyCode);
            }
        }
        return ret;
    }

    /**
     * 验证码登录校验验证码
     * 
     * @return
     */
    @PostMapping(value = "/loginbyvcode")
    public String loginByVerifyCode(@RequestBody PhoneVerifyCode verifyCode, HttpServletRequest request) {
        if (StringUtils.isEmpty(verifyCode.getPhone()) || StringUtils.isEmpty(verifyCode.getVerifycode())) {
            return "手机号或验证码不能为空！";
        }
        // 获取用户
        User userDB = userService.findUserByPhone(verifyCode.getPhone());
        if (userDB == null) {
            return "用户不存在，请先注册！";
        }
        PhoneVerifyCode verifyCodeDB = phoneVerifyCodeService.findPhoneVerifyCode(verifyCode.getPhone());
        boolean isPass = smsService.isCodeValidPass(verifyCode.getVerifycode(), verifyCodeDB.getVerifycode(),
                verifyCodeDB.getCodegeneratetime());
        if (isPass) {
            HttpSession session = request.getSession();
            session.setAttribute("username", userDB.getUsername());
            logger.info(userDB.getUsername() + " 用户登录成功[手机验证码]！");
            return "OK";
        }
        else {
            return "验证码不正确或已失效，请重新发送";
        }
    }

}
