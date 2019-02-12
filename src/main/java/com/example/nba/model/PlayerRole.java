package com.example.nba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * player_role
 * @author 
 */
@Data//getset方法
@ToString//toString方法
@NoArgsConstructor//无参
@AllArgsConstructor//全参
public class PlayerRole implements Serializable {
    /**
     * 球员角色ID
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    private static final long serialVersionUID = 1L;


}