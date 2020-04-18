package com.timain.service;

import com.timain.domain.User;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 14:19
 */
public interface UserService {

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User queryUserByUserName(String username);
}
