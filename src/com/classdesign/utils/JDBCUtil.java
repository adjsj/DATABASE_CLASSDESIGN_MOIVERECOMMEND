package com.classdesign.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JDBCUtil {
    /**
     * 注册驱动
     * 获得连接
     * @throws ClassNotFoundException
     */
    public static void loadDriver()throws ClassNotFoundException{
            Class.forName("com.mysql.jdbc.Driver");
    }
    public static Connection getconnection()throws Exception{
        Connection connection=DriverManager.getConnection("jdbc:mysql:///classdesign","root","zhanghesu");
        return connection;
    }
    public static void release(Connection connection, PreparedStatement preparedStatement){
        if(connection!=null){
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            } }
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        }
}
