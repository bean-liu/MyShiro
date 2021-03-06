package com.example.myshiro.bean;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "system_shiro_permission")
@Data
@ToString
public class Permission implements Serializable {

    private static final long serialVersionUID = 731176175698626920L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name; // 权限名 唯一

    private String url; // 访问地址信息 唯一

    private String description; // 描述信息
}
