package com.itheima.jdbc;

/*
   JDBC的快速入门
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo2_DriverManager {
    public static void main(String[] args) throws Exception {
        //1.注册驱动（可以省略不写）
        //Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接，连接的是本地mysql服务器并且端口默认是3306，可以简化书写
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql语句
        String sql = "update account set money = 2000 where id = 1";

        //4.获取执行sql的对象
        Statement stmt = conn.createStatement();

        //5.执行sql
        int count = stmt.executeUpdate(sql);//受影响的行数

        //6.处理结果
        System.out.println(count);

        //7.释放资源
        stmt.close();
        conn.close();

    }

}
