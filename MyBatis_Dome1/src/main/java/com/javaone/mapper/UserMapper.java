package com.javaone.mapper;

import com.javaone.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 新增
     * @return
     */
    int insertUser();

    /**
     * 修改
     * @return
     */
    int updateUser();

    /**
     * 删除
     * @return
     */
    int deleteUser();

    /**
     * 按照ID查询用户
     * @return
     */
    User getUserById();

    List<User> getUser();

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    User loginUser(@Param("name") String username, @Param("pwd") String password);
}
