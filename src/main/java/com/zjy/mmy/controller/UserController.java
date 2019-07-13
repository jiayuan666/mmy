package com.zjy.mmy.controller;

import com.zjy.mmy.domain.pojo.User;
import com.zjy.mmy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //用户不存在则插入
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public int addUser(@RequestBody User user) {
        log.info("addUser user:{}",user);
        return userService.add(user);
    }

    //更新用户信息（昵称 手机）
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public int updateUser(@RequestBody User user) {
        log.info("updateUser user:{}",user);
        return userService.update(user);
    }

    //通过openid获取用户
    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public User getByOpenID(@RequestParam String openID) {
        log.info("getByOpenID openID:{}",openID);
        return userService.getByOpenID(openID);
    }
}
