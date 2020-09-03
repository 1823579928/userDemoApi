package com.user.demo.mapper;

import com.user.demo.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author ZouJie
 * @ClassName UserMapper
 * @description
 * @date 2020/9/2
 */
@Repository
public interface UserMapper extends Mapper<User> {
}
