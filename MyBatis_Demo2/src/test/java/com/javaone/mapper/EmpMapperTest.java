package com.javaone.mapper;

import com.javaone.pojo.Emp;
import com.javaone.utils.util;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class EmpMapperTest {
    @Test
    public void testGatAllEmp(){
        SqlSession sqlSession = util.gatSqlSession();
        List<Emp> list = sqlSession.getMapper(EmpMapper.class).gatAllEmp();
        list.forEach(System.out::println);
    }
}
