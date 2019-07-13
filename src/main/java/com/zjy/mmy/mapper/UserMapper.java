package com.zjy.mmy.mapper;

import com.zjy.mmy.domain.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int add(User user);
    int delete(int id);
    int update(User user);
    User getByID(int id);
    User getByOpenID(String openID);
}
