package com.example.myshiro.mapper;

import com.example.myshiro.bean.Role;
import com.example.myshiro.bean.ShiroUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ShiroUserMapperTest {

    @Autowired
    ShiroUserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Test
    public void userTest(){
//        Permission permission = new Permission();
//        permission.setName("user:query");
//        permission.setUrl("/query");
//        permission.setDescription("query");
        /*Role role = roleMapper.getById(1);
        role.setPermissions(permissionMapper.findAll());
        roleMapper.save(role);*/

        Optional<ShiroUser> userOptional = userMapper.findById(1);
        System.out.println(userOptional.get());
//        permissionMapper.findAll().forEach(System.out::println);
    }
}