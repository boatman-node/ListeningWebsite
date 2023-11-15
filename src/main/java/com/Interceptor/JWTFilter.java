package com.Interceptor;

import com.pool.JWTToken;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class JWTFilter extends AuthenticatingFilter {

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String jwtToken = httpServletRequest.getHeader("Authorization");

        // 创建JWTToken对象，将JWT作为principal传入
        return new JWTToken(jwtToken);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        // 执行JWT的认证逻辑

        // 如果JWT验证成功，将JWTToken传给Shiro进行后续的认证和授权逻辑

        // 如果JWT验证失败，可以抛出AuthenticationException异常

        return true; // 返回true表示继续执行请求
    }
}
