package com.example.nba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * user
 * @author 
 */
@Data//getset方法
@ToString//toString方法
@NoArgsConstructor//无参
@AllArgsConstructor//全参
public class User implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 用户年龄
     */
    private Integer userAge;

    /**
     * 用户性别(1男2女)
     */
    private Integer userSex;

    /**
     * 用户头像
     */
    private String userPic;

    /**
     * 用户角色
     */
    private String roleId;

    private static final long serialVersionUID = 1L;


    public User(String userName, String userPwd, Integer userAge, Integer userSex, String userPic, String roleId) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.userAge = userAge;
        this.userSex = userSex;
        this.userPic = userPic;
        this.roleId = roleId;
    }
}