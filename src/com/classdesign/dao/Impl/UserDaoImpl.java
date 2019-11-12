package com.classdesign.dao.Impl;

import com.classdesign.dao.UserDao;
import com.classdesign.domain.User;
import com.classdesign.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    public User login(User user){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            //获得连接
            JDBCUtil.loadDriver();
            connection= JDBCUtil.getconnection();
            //预编译语句
            String sql="SELECT * FROM t_user WHERE username = ? AND userpassword = ?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                User exitUser=new User();
                exitUser.setUserid(resultSet.getInt("userid"));
                exitUser.setUsername(resultSet.getString("username"));
                exitUser.setPassword(resultSet.getString("userpassword"));
                return exitUser;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement);
        }
        return null;
    }
}
