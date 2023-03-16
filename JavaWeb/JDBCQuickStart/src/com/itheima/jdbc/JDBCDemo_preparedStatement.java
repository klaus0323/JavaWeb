package com.itheima.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * JDBC quick start
 */
public class JDBCDemo_preparedStatement {


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
        String pwd = "2334";

        // 定义sql
        String sql = "select * from tb_user where username = ? and password = ?";

        // 获取statment对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, name);
        pstmt.setString(2, pwd);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }


        pstmt.close();
        conn.close();
        rs.close();

    }


}
