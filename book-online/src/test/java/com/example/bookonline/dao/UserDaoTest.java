package com.example.bookonline.dao;

import com.example.bookonline.dao.impl.UserDaoImpl;
import com.example.bookonline.entity.User;
import org.testng.annotations.Test;

class UserDaoTest {
    @Test
    void insertUser() {
        UserDao userDao = new UserDaoImpl();
        User user = User.builder().account("root").nickname("root").password("root").address("江苏南京").
                avatar("https://s21.ax1x.com/2024/09/28/pA1PVb9.jpg").build();
        userDao.insertUser(user);
    }
}