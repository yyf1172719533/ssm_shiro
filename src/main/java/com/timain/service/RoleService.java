package com.timain.service;

import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 14:19
 */
public interface RoleService {

    /**
     * 根据用户ID查询用户角色
     * @param userId
     * @return
     */
    List<String> queryRolesByUserId(Integer userId);
}
