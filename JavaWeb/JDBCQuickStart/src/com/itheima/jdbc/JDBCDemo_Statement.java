package com.itheima.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC quick start
 */
public class JDBCDemo_Statement {

    @Test
    public void testDML() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String password = "010323";
        String url = "jdbc:mysql:///jdbcdata/useSSL=false";
        String userName = "root";
        Connection conn = DriverManager.getConnection(url, userName, password);

        String sql = "update employee set salary = 24000 where name = \"peanut\"";

        Statement stmt = conn.createStatement();

        int count = stmt.executeUpdate(sql); //执行完dml语句之后受影响的行数;

        System.out.println(count);

        stmt.close();
        conn.close();


    }

    @Test
    // ddl is for table and database
    public void testDDL() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String password = "010323";
        String url = "jdbc:mysql:///jdbcdata?useSSL=false";
        String userName = "root";
        Connection conn = DriverManager.getConnection(url, userName, password);

        String sql = "create database dbtest2";

        Statement stmt = conn.createStatement();

        int count = stmt.executeUpdate(sql); //执行完dml语句之后受影响的行数;

        System.out.println(count);

        stmt.close();
        conn.close();


    }
}
