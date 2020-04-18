package com.timain.realm;

import com.timain.domain.Permission;
import com.timain.domain.User;
import com.timain.pojo.ActiverUser;
import com.timain.service.PermissionService;
import com.timain.service.RoleService;
import com.timain.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 13:42
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 授权
     * @param principal
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        ActiverUser activerUser = (ActiverUser) principal.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<String> roles = activerUser.getRoles();
        List<String> permissions = activerUser.getPermissions();
        if (null!=roles && roles.size()>0) {
            info.addRoles(roles);
        }
        if (null!=permissions && permissions.size()>0) {
            info.addStringPermissions(permissions);
        }
        return info;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();
        User user = userService.queryUserByUserName(username);
        if (null!=user) {
            //查询角色
            List<String> roles = this.roleService.queryRolesByUserId(user.getUserid());
            //查询权限
            List<String> permissions = this.permissionService.queryPermissionsByUserId(user.getUserid());
            ActiverUser activerUser = new ActiverUser(user, roles, permissions);
            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername() + user.getAddress());
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activerUser, user.getUserpwd(), credentialsSalt, this.getName());
            return info;
        }
        return null;
    }
}
