package com.user.demo.serivce.imp;

import com.user.demo.entity.User;
import com.user.demo.mapper.UserMapper;
import com.user.demo.serivce.UserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;

/**
 * @author ZouJie
 * @ClassName UserServiceImpl
 * @description
 * @date 2020/9/2
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByExample(user, Example.builder(User.class).where(Sqls.custom().andEqualTo("id", user.getId())).build());
    }

    @Override
    public HashMap<String, Object> listUser(Integer currentPage, Integer pageSize) {
        Sqls sqls = Sqls.custom();
        List<User> userList = userMapper.selectByExampleAndRowBounds(Example.builder(User.class).where(sqls).orderByDesc("id").build(), new RowBounds((currentPage - 1) * pageSize, pageSize));
        int count = userMapper.selectCountByExample(Example.builder(User.class).build());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("count", count);
        hashMap.put("data", userList);
        return hashMap;
    }

    @Override
    public int deleteUsert(User user) {
        return userMapper.delete(user);
    }
}
