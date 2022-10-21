package com.javaone.mapper;

import com.javaone.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;


public class UserMapperTest {
    @Test
    public void testUserMapper() throws Exception {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int user = userMapper.insertUser();
//        sqlSession.commit();
        System.out.println(user);
    }

    @Test
    public void testUpdateUser() throws Exception {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.updateUser();
        System.out.println(i);
    }

    @Test
    public void testDeleteUser() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUser();
        System.out.println(i);
    }

    @Test
    public void testGetUserById() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        UserMapper mapper = new SqlSessionFactoryBuilder().build(is).openSession(true).getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
    }

    @Test
    public void testGetUser() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        UserMapper mapper = new SqlSessionFactoryBuilder().build(is).openSession(true).getMapper(UserMapper.class);
        List<User> user = mapper.getUser();
        System.out.println(user);
    }
}
