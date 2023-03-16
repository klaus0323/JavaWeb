package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC quick start
 */
public class JDBCDemo_Connection {


    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String password = "010323";
        String url = "jdbc:mysql:///jdbcdata/useSSL=false";
        String userName = "root";
        Connection conn = DriverManager.getConnection(url, userName, password);

        String sql = "update employee set salary = 24000 where name = \"peanut\"";

        Statement stmt = conn.createStatement();

        int count = stmt.executeUpdate(sql);

        System.out.println(count);

        stmt.close();
        conn.close();


    }
}
