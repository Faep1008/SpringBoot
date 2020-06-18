package com.faep.service.api;

import com.faep.entity.User;

import java.util.List;

/**
 * 描述： 用户service接口
 * 作者： Faep
 * 创建时间： 2020/6/18 9:35
 * 版本： [1.0, 2020/6/18]
 * 版权： Faep
 */
public interface IUserService {
    /**
     * 新增一个用户
     * @param user
     * @return
     */
    int addNewUser(User user);

    /**
     * 删除一个用户
     * @param rowguid
     * @return
     */
    int removeUserByGuid(String rowguid);

    /**
     * 修改用户密码
     * @param user
     * @return
     */
    int updateUserInfo(User user);

    /**
     * 根据用户Guid查询一个用户
     * @param rowguid
     * @return
     */
    User findUserByGuid(String rowguid);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAllUsers();
}
