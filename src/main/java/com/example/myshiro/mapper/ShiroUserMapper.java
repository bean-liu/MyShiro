package com.example.myshiro.mapper;

import com.example.myshiro.bean.ShiroUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiroUserMapper extends JpaRepository<ShiroUser, Integer> {
    ShiroUser findByUsername(String username);

    ShiroUser findByUsernameAndPassword(String username, String password);
}