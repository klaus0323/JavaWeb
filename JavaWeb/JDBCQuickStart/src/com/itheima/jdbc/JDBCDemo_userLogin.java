package com.itheima.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC quick start
 */
public class JDBCDemo_userLogin {


    @Test
    // ddl is for table and database
    public void testLogin() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String password = "010323";
        String url = "jdbc:mysql:///jdbcdata?useSSL=false";
        String userName = "root";
        Connection conn = DriverManager.getConnection(url, userName, password);

        // 接受用户名密码
        String name = "pecan";
        String pwd = "234";

        // 定义sql
        String sql = "select * from tb_user where username = '" + name + "' and password = '" + pwd + "' ";

        // 获取statment对象
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }

    }
        @Test
        // ddl is for table and database
        public void testInject() throws Exception {
            Class.forName("com.mysql.jdbc.Driver");

            String password = "010323";
            String url = "jdbc:mysql:///jdbcdata?useSSL=false";
            String userName = "root";
            Connection conn = DriverManager.getConnection(url, userName, password);

            // 接受用户名密码
            String name = "pecadsfsdn";
            String pwd = "'or'1' = '1'"; //sql injection

            // 定义sql
            String sql = "select * from tb_user where username = '" + name + "' and password = '" + pwd + "' ";

            // 获取statment对象
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                System.out.println("success");
            } else {
                System.out.println("fail");
            }

        // 7. 释放资源
//        stmt.close();
//        conn.close();
//        rs.close();


    }


}
