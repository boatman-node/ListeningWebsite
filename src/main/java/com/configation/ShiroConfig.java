package com.configation;

import com.Interceptor.JWTFilter;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Filter;

@Configuration
public class ShiroConfig {

    @Bean
    public Realm realm() {
        // 创建自定义的Realm，用于实现用户认证和授权逻辑
        return new CustomRealm();
    }

    @Bean
    public DefaultWebSecurityManager securityManager(Realm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);

        // 添加JWT过滤器
        Map<String, Filter> filters = new LinkedHashMap<>();
        filters.put("jwt", new JWTFilter());
        shiroFilter.setFilters(filters);

        // 设置URL拦截规则
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/api/login", "anon"); // 登录接口不需要认证
        filterChainDefinitionMap.put("/**", "jwt"); // 其他接口都需要认证
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilter;
    }
}