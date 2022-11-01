package com.javaone.util;

import java.sql.*;
import java.util.List;

public class DBUtil {

    //数据库连接信息
    private static String driver = "com.mysql.cj.jdbc.Driver";

    private static String url = "jdbc:mysql://localhost:3306/mybatis";

    private static String username = "root";

    private static String password = "123456";

    private static Connection connection = null;
    private static ResultSet resultSet = null;
    private static PreparedStatement statement = null;

    //静态加载驱动
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //获取连接的方法
    public static Connection getConn(){
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    //查询
    public static ResultSet query(String sql, List<?> params){
        try {
            statement = getConn().prepareStatement(sql);
            if (params != null && params.size() > 0){
                for (int i = 0; i < params.size(); i++) {
                    statement.setObject(i+1, params.get(i));
                }
            }
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    //修改
    public static int update(String sql,List<?> params){
        try {
            statement = getConn().prepareStatement(sql);
            if (params != null && params.size() > 0){
                for (int i = 0; i < params.size(); i++) {
                    statement.setObject(i+1, params.get(i));
                }
            }
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //关闭数据库
    public static void close(){
        if (connection != null){
            try {
                connection.close();
                System.out.println("connection关闭");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
                System.out.println("resultSet关闭");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (statement != null) {
            try {
                statement.close();
                System.out.println("statement关闭");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
