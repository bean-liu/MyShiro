package com.example.myshiro.bean;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "system_shiro_role")
@Data
@ToString
public class Role implements Serializable {

    private static final long serialVersionUID = -2952758606530125551L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name; // 角色名 唯一

    private String description; // 描述信息

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission",
            joinColumns = {
            @JoinColumn(
                    name = "role_id", referencedColumnName="id"
            )
            },
            inverseJoinColumns = {
            @JoinColumn(
                    name = "permission_id", referencedColumnName="id"
            )}
    )
    private List<Permission> permissions; // 一个用户角色对应多个权限
}