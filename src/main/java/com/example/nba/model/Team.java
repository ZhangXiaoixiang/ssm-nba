package com.example.nba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * team
 * @author 
 */
@Data//getset方法
@ToString//toString方法
@NoArgsConstructor//无参
@AllArgsConstructor//全参
public class Team implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 球队编码ID
     */
    private Integer teamId;

    /**
     * 球队英文名称
     */
    private String teamNameEn;

    /**
     * 球队中文名称
     */
    private String teamNameCh;

    /**
     * 分区1西2东
     */
    private Integer zone;

    /**
     * 胜场数
     */
    private Integer victory;

    /**
     * 败场数
     */
    private Integer defeat;

    /**
     * 排名
     */
    private Integer ranking;

    private static final long serialVersionUID = 1L;

    public Team(Integer teamId, String teamNameEn, String teamNameCh, Integer zone, Integer victory, Integer defeat, Integer ranking) {
        this.teamId = teamId;
        this.teamNameEn = teamNameEn;
        this.teamNameCh = teamNameCh;
        this.zone = zone;
        this.victory = victory;
        this.defeat = defeat;
        this.ranking = ranking;
    }
}