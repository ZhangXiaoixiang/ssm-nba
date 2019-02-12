package com.example.nba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * role
 * @author 
 */
@Data//getset方法
@ToString//toString方法
@NoArgsConstructor//无参
@AllArgsConstructor//全参
public class Role implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 角色对应id(1:超级管理员2:管理员3:一般人员)
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色(1:超级管理员2:管理员3:一般人员)对应的权限
     */
    private String rolePrivilege;

    private static final long serialVersionUID = 1L;

    public Role(Integer roleId, String roleName, String rolePrivilege) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.rolePrivilege = rolePrivilege;
    }
}