package com.zjy.mmy.service;

import com.zjy.mmy.domain.pojo.User;

public interface UserService {

    User getByID(int userID);
    User getByOpenID(String openID);

    int add(User user);

    int update(User user);
}
