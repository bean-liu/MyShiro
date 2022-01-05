package com.example.myshiro.config;

import com.example.myshiro.bean.Permission;
import com.example.myshiro.mapper.PermissionMapper;
import com.example.myshiro.realm.UserAuthRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
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
        return securityManager;
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
}
