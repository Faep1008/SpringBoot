package com.faep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faep.entity.User;
import com.faep.mapper.UserMapper;
import com.faep.service.api.IUserService;

/**
 * 描述： 用户service实现类
 * 作者： Faep
 * 创建时间： 2020/6/18 9:36
 * 版本： [1.0, 2020/6/18]
 * 版权： Faep
 */
@Service
public class UserService implements IUserService
{

    @Autowired
    @SuppressWarnings("all")
    private UserMapper userMapper;

    @Override
    public int addNewUser(User user) {
        return userMapper.addNewUser(user);
    }

    @Override
    public int removeUserByGuid(String rowguid) {
        return userMapper.removeUserByGuid(rowguid);
    }

    @Override
    public int updateUserInfo(User user) {
        return userMapper.updateUserInfo(user);
    }

    @Override
    public User findUserByGuid(String rowguid) {
        return userMapper.findUserByGuid(rowguid);
    }

    @Override
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public User findUserByLoginId(String loginid) {
        return userMapper.findUserByLoginId(loginid);
    }

    @Override
    public User findUserByPhone(String phone) {
        return userMapper.findUserByPhone(phone);
    }

    @Override
    public User findUserByEmail(String email) {
        return userMapper.findUserByEmail(email);
    }
}
