package com.javaone.utils;

import com.javaone.pojo.Emp;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class utilTest {
    @Test
    public void testUtil() throws SQLException {
        Connection conn = util.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("select * from t_emp");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Emp> list = new ArrayList<>();
        while (resultSet.next()) {
            Emp emp = new Emp();
            emp.setEid(resultSet.getInt("eid"));
            emp.setEmpName(resultSet.getString("emp_name"));
            emp.setAge(resultSet.getInt("age"));
            emp.setSex(resultSet.getString("sex"));
            emp.setEmail(resultSet.getString("email"));
            list.add(emp);
        }
        list.forEach(Emp -> System.out.println(Emp));
    }
}
