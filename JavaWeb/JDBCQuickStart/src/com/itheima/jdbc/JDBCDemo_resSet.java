package com.itheima.jdbc;

import org.junit.jupiter.api.Test;
import com.itheima.pojo.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC quick start
 */
public class JDBCDemo_resSet {


    @Test
    // ddl is for table and database
    public void testDDL() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String password = "010323";
        String url = "jdbc:mysql:///jdbcdata?useSSL=false";
        String userName = "root";
        Connection conn = DriverManager.getConnection(url, userName, password);

        // 定义sql
        String sql = "select * from employee";

        // 获取statment对象
        Statement stmt = conn.createStatement();

        // 执行sql
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            double sal = rs.getDouble(4);

            System.out.println(id);
            System.out.println(name);
            System.out.println(sal);
        }


        // 7. 释放资源
        stmt.close();
        conn.close();
        rs.close();


    }

    @Test
    // ddl is for table and database
    public void testres2() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String password = "010323";
        String url = "jdbc:mysql:///jdbcdata?useSSL=false";
        String userName = "root";
        Connection conn = DriverManager.getConnection(url, userName, password);

        // 定义sql
        String sql = "select * from employee";

        // 获取statment对象
        Statement stmt = conn.createStatement();

        // 执行sql
        ResultSet rs = stmt.executeQuery(sql);

        List<Account> list = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            double sal = rs.getDouble(4);

            Account account = new Account();
            account.setId(id);
            account.setName(name);
            account.setSal(sal);


            list.add(account);


        }
        System.out.println(list);


        // 7. 释放资源
        stmt.close();
        conn.close();
        rs.close();


    }
}
