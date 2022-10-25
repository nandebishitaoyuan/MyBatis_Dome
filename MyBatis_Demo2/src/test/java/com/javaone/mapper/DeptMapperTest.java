package com.javaone.mapper;

import com.javaone.pojo.Dept;
import com.javaone.utils.util;
import org.junit.Test;

public class DeptMapperTest {
    @Test
    public void testGatAllEmp(){
        Dept emp = util.gatSqlSession().getMapper(DeptMapper.class).getDeptAndEmp(1);
        System.out.println(emp);
    }

}
