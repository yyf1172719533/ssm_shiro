package com.timain.service;

import com.timain.domain.Permission;

import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 14:20
 */
public interface PermissionService {

    /**
     * 根据用户ID查询用户权限
     * @param userId
     * @return
     */
    List<String> queryPermissionsByUserId(Integer userId);
}
