package com.example.myshiro.mapper;

import com.example.myshiro.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleMapper extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}