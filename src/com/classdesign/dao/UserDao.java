package com.classdesign.dao;

import com.classdesign.domain.User;

public interface UserDao {
    User login(User user);
    User ifExitUser(User user);
    User ifExitphone_number(User user);
    boolean creatNewUser(User user);
    boolean reset_pwd(User user);
}
