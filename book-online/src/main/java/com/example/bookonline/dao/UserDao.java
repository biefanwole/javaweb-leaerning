package com.example.bookonline.dao;

import com.example.bookonline.entity.User;

public interface UserDao {

    int insertUser(User user);      //    command+shirt+T
    User findUser(User user);
}
