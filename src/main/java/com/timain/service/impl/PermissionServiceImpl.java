package com.timain.service.impl;

import com.timain.domain.Permission;
import com.timain.mapper.PermissionMapper;
import com.timain.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 14:20
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 根据用户ID查询用户权限
     *
     * @param userId
     * @return
     */
    public List<String> queryPermissionsByUserId(Integer userId) {
        List<Permission> permissionList = permissionMapper.queryPermissionsByUserId(userId);
        List<String> list = new ArrayList<String>();
        for (Permission permission : permissionList) {
            list.add(permission.getPercode());
        }
        return list;
    }
}
