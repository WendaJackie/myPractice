package com.itheima.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * API详解
 */
public class JDBCDemo7_PreparedStatement {


    @Test
    public void testPreparedStatement() throws  Exception {

       //2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
       String url = "jdbc:mysql:///db1?useSSL=false";
       String username = "root";
       String password = "123456";
       Connection conn = DriverManager.getConnection(url, username, password);

       //接受用户名和密码
        String name = "zhangsan";
        String pwd = "'or '1'='1";

        // 定义sql
        String sql = "select * from tb_user where username = ? and password = ?";

        //获取stmt对象
        PreparedStatement psmt = conn.prepareStatement(sql);

        //设置?的值
        psmt.setString(1,name);
        psmt.setString(2,pwd);

        //执行sql
        ResultSet rs = psmt.executeQuery();


        //判断登录是否成功
        if(rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }


        //7.释放资源
        rs.close();
        psmt.close();
        conn.close();
    }

    /**
     * PreparedStatement的原理
     * @throws Exception
     */

    @Test
    public void testPreparedStatement2() throws  Exception {

        //2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql:///db1?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        //接受用户名和密码
        String name = "zhangsan";
        String pwd = "'or '1'='1";

        // 定义sql
        String sql = "select * from tb_user where username = ? and password = ?";

        //获取stmt对象
        PreparedStatement psmt = conn.prepareStatement(sql);

        //设置?的值
        psmt.setString(1,name);
        psmt.setString(2,pwd);

        //执行sql
        ResultSet rs = psmt.executeQuery();


        //判断登录是否成功
        if(rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }


        //7.释放资源
        rs.close();
        psmt.close();
        conn.close();
    }



}
