package com.classdesign.service.Impl;

import com.classdesign.dao.Impl.UserDaoImpl;
import com.classdesign.dao.UserDao;
import com.classdesign.domain.User;
import com.classdesign.service.Userservice;

public class UserserviceImpl implements Userservice {
    public User login(User user){
        //调用Dao层 查看用户是否存在
        UserDao userDao=new UserDaoImpl();
        return userDao.login(user);
    }
    public User ifExitUser(User user){
        UserDao userDao=new UserDaoImpl();
        return userDao.ifExitUser(user);
    }

    @Override
    public User ifExitphone_number(User user) {
        UserDao userDao=new UserDaoImpl();
        return userDao.ifExitphone_number(user);
    }

    public boolean creatNewUser(User user){
        UserDao userdao=new UserDaoImpl();
        if(userdao.creatNewUser(user)){
            return true;
        }
        return false;
    }

    @Override
    public boolean reset_pwd(User user) {
        UserDao userDao=new UserDaoImpl();
        return userDao.reset_pwd(user);
    }
}
