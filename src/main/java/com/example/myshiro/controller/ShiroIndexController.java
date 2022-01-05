package com.example.myshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ShiroIndexController {

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> map){
        String username = map.get("username");
        String password = map.get("password");

        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);

            HashMap<String, Object> result = new HashMap<>();
            result.put("code", 0);
            return result;
        } catch (Exception e){
            HashMap<String, Object> result = new HashMap<>();
            result.put("code", 1);
            return result;
        }
    }

    @GetMapping("/logout")
    public Map<String, Object> logout(){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();

            HashMap<String, Object> result = new HashMap<>();
            result.put("code", 0);
            return result;
        } catch (Exception e){
            HashMap<String, Object> result = new HashMap<>();
            result.put("code", 1);
            return result;
        }
    }

    @GetMapping("/add")
    public Map<String, Object> add(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 0);
        return result;
    }

    @GetMapping("/update")
    public Map<String, Object> update(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 0);
        return result;
    }

    @GetMapping("/delete")
    public Map<String, Object> delete(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 0);
        return result;
    }

    @GetMapping("/query")
    public Map<String, Object> query(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 0);
        return result;
    }

    @GetMapping("/anon")
    public Map<String, Object> anon(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 0);
        return result;
    }
}