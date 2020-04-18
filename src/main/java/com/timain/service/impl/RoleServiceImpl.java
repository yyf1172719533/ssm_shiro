package com.timain.service.impl;

import com.timain.domain.Role;
import com.timain.mapper.RoleMapper;
import com.timain.service.RoleService;
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
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 根据用户ID查询用户角色
     *
     * @param userId
     * @return
     */
    public List<String> queryRolesByUserId(Integer userId) {
        List<Role> roleList = roleMapper.queryRolesByUserId(userId);
        List<String> list = new ArrayList<String>();
        for (Role role : roleList) {
            list.add(role.getRolename());
        }
        return list;
    }
}
