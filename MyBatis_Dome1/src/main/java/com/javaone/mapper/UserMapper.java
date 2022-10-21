package com.javaone.mapper;

import com.javaone.pojo.User;

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
}
