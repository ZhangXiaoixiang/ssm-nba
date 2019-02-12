package com.example.nba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * competition_platform
 * @author 
 */
@Data//getset方法
@ToString//toString方法
@NoArgsConstructor//无参
@AllArgsConstructor//全参
public class CompetitionPlatform implements Serializable {
    /**
     * 赛事直播平台ID
     */
    private Integer id;

    /**
     * 平台名称
     */
    private String name;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}