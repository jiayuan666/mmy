package com.zjy.mmy.service.impl;

import com.zjy.mmy.mapper.UserMapper;
import com.zjy.mmy.domain.pojo.User;
import com.zjy.mmy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getByID(int id) {
        return userMapper.getByID(id);
    }

    @Override
    public User getByOpenID(String openID) {
        return userMapper.getByOpenID(openID);
    }

    @Override
    public int add(User user) {
        int result;
        if(null != userMapper.getByOpenID(user.getOpenID())) {
            log.info("openid已经存在");
            throw new IllegalArgumentException("openid已经存在");
        }
        result = userMapper.add(user);
        if(0 == result) {
           log.info("insert 0 row");
           return 0;
        }
        return user.getUserID();
    }

    @Override
    public int update(User user) {
        User user1 = userMapper.getByID(user.getUserID());
        if(user1 == null) {
            log.info("用户不存在");
            throw new IllegalArgumentException("用户不存在");
        }
        return userMapper.update(user);
    }
}
