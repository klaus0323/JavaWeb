package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC quick start
 */
public class JDBCDemo_DriverManager {


    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String password = "010323";
        String url = "jdbc:mysql:///jdbcdata?useSSL=false";
        String userName = "root";
        Connection conn = DriverManager.getConnection(url, userName, password);

        String sql1 = "update employee set salary = 190003 where name = \"peanut\"";
        String sql2 = "update employee set salary = 2404 where name = \"pecan\"";

        Statement stmt = conn.createStatement();

        //开启事务

//        用异常处理机制
        try {
            conn.setAutoCommit(false);

            int count1 = stmt.executeUpdate(sql1);

            System.out.println(count1);

            int c = 3/0;
            int count2 = stmt.executeUpdate(sql2);

            System.out.println(count2);

            conn.commit();
        } catch (Exception throwable) {

            conn.rollback();
            throwable.printStackTrace();
        }





        //释放资源
        stmt.close();
        conn.close();


    }
}
