package com.user.demo.serivce;

import com.user.demo.entity.User;

import java.util.HashMap;

/**
 * @author ZouJie
 * @ClassName UserService
 * @description
 * @date 2020/9/2
 */
public interface UserService {
    int insertUser(User user);

    int updateUser(User user);

    HashMap<String, Object> listUser(Integer currentPage, Integer pageSize);

    int deleteUsert(User user);
}
