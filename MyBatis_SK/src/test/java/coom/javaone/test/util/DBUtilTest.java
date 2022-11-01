package coom.javaone.test.util;

import com.javaone.pojo.User;
import com.javaone.util.DBUtil;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtilTest {
    @Test
    public void test(){
        ResultSet resultSet = DBUtil.query("SELECT * FROM user", null);
            try {
                while (resultSet.next()) {
                    System.out.print(resultSet.getInt(1)+"\t");
                    System.out.print(resultSet.getString(2)+"\t");
                    System.out.print(resultSet.getString(3)+"\t");
                    System.out.println(resultSet.getString(4));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                DBUtil.close();
            }
    }

    @Test
    public void testUpdate(){
        String sql = "insert into user values (?,?,?,?)";
        User user = new User(null,"yingyngying","123456","123456@qq.com");
        List<Object> list = new ArrayList<>();
        list.add(user.getId());
        list.add(user.getName());
        list.add(user.getPwd());
        list.add(user.getEmail());
        int update = DBUtil.update(sql, list);
        System.out.println(update);
    }
}
