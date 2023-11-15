package com.configation;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 根据用户信息进行授权逻辑的处理
        // 可以查询数据库或其他数据源，获取用户的权限信息并构建AuthorizationInfo对象返回
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String jwtToken = (String) token.getPrincipal();

        // 验证JWT的有效性，解析JWT获取用户信息

        // 如果JWT无效，可以抛出AuthenticationException异常

        // 否则构建AuthenticationInfo对象返回
        return new SimpleAuthenticationInfo(jwtToken, jwtToken, getName());
    }
}
