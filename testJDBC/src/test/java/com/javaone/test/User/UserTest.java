package com.javaone.test.User;

import com.javaone.pojo.User;
import com.javaone.util.DButil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserTest {
    @Test
    public void testUser() throws Exception {
        Connection conn = DButil.getConn();
        PreparedStatement statement = conn.prepareStatement("insert into user values (?,?,?,?)");
        User user = new User(2,"qwe","123456","123456@qq.com");
        statement.setObject(1,user.getId());
        statement.setObject(2,user.getName());
        statement.setObject(3,user.getPwd());
        statement.setObject(4,user.getEmail());
        int i = statement.executeUpdate();
        System.out.println(i);

    }
}
