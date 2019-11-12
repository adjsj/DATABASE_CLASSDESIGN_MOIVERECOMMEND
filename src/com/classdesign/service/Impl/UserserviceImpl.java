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
}
