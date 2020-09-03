package com.user.demo.controller;

import com.user.demo.entity.User;
import com.user.demo.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author ZouJie
 * @ClassName UserController
 * @description
 * @date 2020/9/2
 */
@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public int insertUser(@RequestBody User user) {
        System.out.println("user = " + user.toString());
        return userService.insertUser(user);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public int updateUser(@RequestBody User user) {
        System.out.println("user = " + user.toString());
        return userService.updateUser(user);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public int deleteUpdate(@RequestBody User user) {
        return userService.deleteUsert(user);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public HashMap<String, Object> listUser(Integer currentPage, Integer pageSize) {
        return userService.listUser(currentPage, pageSize);
    }

}
