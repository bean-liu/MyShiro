package com.example.myshiro.mapper;

import com.example.myshiro.bean.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionMapper extends JpaRepository<Permission, Integer> {
    Permission findByName(String name);
}