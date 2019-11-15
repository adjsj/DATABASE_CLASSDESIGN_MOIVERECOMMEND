package com.classdesign.service;

import com.classdesign.domain.User;

public interface Userservice {
    User login(User user);
    User ifExitUser(User user);
    User ifExitphone_number(User user);
    boolean creatNewUser(User user);
    boolean reset_pwd(User user);
}
