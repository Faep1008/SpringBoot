package com.faep.mapper;

import com.faep.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 描述： 用户Mapper
 * 作者： Faep
 * 创建时间： 2020/6/18 9:10
 * 版本： [1.0, 2020/6/18]
 * 版权： Faep
 */
@Mapper
public interface UserMapper {

    /**
     * 新增一个用户
     */
    @Insert("insert into user values (#{rowguid}, #{username}, #{loginid}, #{password}, #{phone}, #{lastlogintime}, #{enabled})")
    int addNewUser(User user);

    /**
     * 删除一个用户
     */
    @Delete("delete from user where rowguid=#{rowguid}")
    int removeUserByGuid(String rowguid);

    /**
     * 修改用户密码
     */
    @Update("update user set password=#{password} where rowguid=#{rowguid}")
    int updateUserInfo(User user);

    /**
     * 根据用户Guid查询一个用户
     */
    @Select("select * from user where rowguid=#{rowguid}")
    User findUserByGuid(String rowguid);

    /**
     * 查询所有用户
     */
    @Select("select * from user")
    List<User> findAllUsers();

    /**
     * 根据登录名获取用户
     * @param loginid
     * @return
     */
    @Select("select * from user where loginid=#{loginid}")
    User findUserByLoginId(String loginid);

    /**
     * 根据手机号获取用户
     * @param phone
     * @return
     */
    @Select("select * from user where phone=#{phone}")
    User findUserByPhone(String phone);
}
