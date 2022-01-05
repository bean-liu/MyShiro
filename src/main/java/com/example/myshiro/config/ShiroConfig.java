package com.example.myshiro.config;

import com.example.myshiro.bean.Permission;
import com.example.myshiro.mapper.PermissionMapper;
import com.example.myshiro.realm.UserAuthRealm;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private UserAuthRealm userAuthRealm;

    @Bean
    public ShiroFilterFactoryBean factoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);

        factoryBean.setFilterChainDefinitionMap(setFilterChainDefinitionMap());

        return factoryBean;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userAuthRealm);
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
        return cookieRememberMeManager;
    }

    public SimpleCookie rememberMeCookie(){
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setMaxAge(259200); // 记住三天
        return simpleCookie;
    }

    private Map<String, String> setFilterChainDefinitionMap(){
        Map<String, String> filterMap = new LinkedHashMap<>();
        List<Permission> allPermission = permissionMapper.findAll();
        for(Permission p: allPermission){
            filterMap.put(p.getUrl(), "perms[" + p.getName() + "]");
        }
        filterMap.put("/**", "anon");
        return filterMap;
    }

    // 注解支持
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
