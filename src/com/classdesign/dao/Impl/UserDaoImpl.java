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

    @Override
    public User ifExitUser(User user) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            JDBCUtil.loadDriver();
            connection=JDBCUtil.getconnection();
            String sql="SELECT * FROM t_user WHERE username=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                User exituser=new User();
                exituser.setUserid(resultSet.getInt("userid"));
                exituser.setUsername(resultSet.getString("username"));
                exituser.setPassword(resultSet.getString("userpassword"));
                exituser.setPhone_number(resultSet.getString("phone_number"));
                return exituser;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement);
        }
        return null;
    }

    @Override
    public User ifExitphone_number(User user) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            JDBCUtil.loadDriver();
            connection=JDBCUtil.getconnection();
            String sql="SELECT * FROM t_user WHERE phone_number=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getPhone_number());
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                User exituser=new User();
                exituser.setUserid(resultSet.getInt("userid"));
                exituser.setUsername(resultSet.getString("username"));
                exituser.setPassword(resultSet.getString("userpassword"));
                exituser.setPhone_number(resultSet.getString("phone_number"));
                return exituser;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement);
        }
        return null;
    }

    @Override
    public boolean creatNewUser(User user) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            JDBCUtil.loadDriver();
            connection=JDBCUtil.getconnection();
            String sql="INSERT INTO t_user(username,userpassword,phone_number) VALUES(?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getPhone_number());
            int status=preparedStatement.executeUpdate();
            if(status>0){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement);
        }
        return false;
    }

    @Override
    public boolean reset_pwd(User user) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            JDBCUtil.loadDriver();
            connection=JDBCUtil.getconnection();
            String sql="update t_user set userpassword = ? where username = ?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getPassword());
            preparedStatement.setString(2,user.getUsername());
            int num=preparedStatement.executeUpdate();
            if(num>0){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement);
        }
        return false;

    }
}
