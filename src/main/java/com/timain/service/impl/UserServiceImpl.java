package com.timain.service.impl;

import com.timain.domain.User;
import com.timain.mapper.UserMapper;
import com.timain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 14:20
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    public User queryUserByUserName(String username) {
        return userMapper.queryUserByUserName(username);
    }
}
