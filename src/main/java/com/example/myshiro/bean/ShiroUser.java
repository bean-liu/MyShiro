package com.example.myshiro.bean;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "system_shiro_user")
@Data

public class ShiroUser implements Serializable {

    private static final long serialVersionUID = 2964994576390554797L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;// 用户名 唯一
    private String password;// 用户密码

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {
                    @JoinColumn(
                            name = "user_id", referencedColumnName="id"
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "role_id", referencedColumnName="id"
                    )}
    )
    private List<Role> roles;// 用户角色 一个用户可能有一个角色，也可能有 多个角色

}
