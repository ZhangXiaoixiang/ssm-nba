package com.example.nba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * player_record
 * @author 
 */
@Data//getset方法
@ToString//toString方法
@NoArgsConstructor//无参
@AllArgsConstructor//全参
public class PlayerRecord implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 球员编码
     */
    private Integer recordId;

    /**
     * 球员中文名称
     */
    private String nameCh;

    /**
     * 联盟排名
     */
    private Integer playerRank;

    /**
     * 得分
     */
    private Float point;

    /**
     * 篮板球
     */
    private Float rebound;

    /**
     * 助攻
     */
    private Float assist;

    /**
     * 抢断
     */
    private Float steal;

    /**
     * 盖帽
     */
    private Float block;

    /**
     * 失误
     */
    private Float fault;

    /**
     * 命中率
     */
    private Float accuracy;

    /**
     * 上场时间
     */
    private Float playingTime;

    /**
     * 球员图片路径
     */
    private String picPath;

    private static final long serialVersionUID = 1L;

    public PlayerRecord(Integer recordId, String nameCh, Integer playerRank, Float point, Float rebound, Float assist, Float steal, Float block, Float fault, Float accuracy, Float playingTime, String picPath) {
        this.recordId = recordId;
        this.nameCh = nameCh;
        this.playerRank = playerRank;
        this.point = point;
        this.rebound = rebound;
        this.assist = assist;
        this.steal = steal;
        this.block = block;
        this.fault = fault;
        this.accuracy = accuracy;
        this.playingTime = playingTime;
        this.picPath = picPath;
    }
}