package com.example.myshiro.realm;

import com.example.myshiro.bean.Permission;
import com.example.myshiro.bean.Role;
import com.example.myshiro.bean.ShiroUser;
import com.example.myshiro.mapper.ShiroUserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAuthRealm extends AuthorizingRealm {

    @Autowired
    private ShiroUserMapper shiroUserMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        ShiroUser user = (ShiroUser) principalCollection.getPrimaryPrincipal();
        for(Role role : user.getRoles()){
            authorizationInfo.addRole(role.getName());
            for (Permission permission : role.getPermissions()){
                authorizationInfo.addStringPermission(permission.getName());
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        ShiroUser user = shiroUserMapper.findByUsername(token.getUsername());
        if(user == null){
            return null;
        }
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        return authenticationInfo;
    }

    /*@Override
    protected void clearCache(PrincipalCollection principals) {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principalCollection);
    }*/
}
