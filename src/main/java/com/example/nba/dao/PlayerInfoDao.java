package com.example.nba.dao;

import com.example.nba.model.PlayerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * PlayerInfoDao
 *
 * @author 10905 2019/1/8
 * @version 1.0
 */
@Mapper
public interface PlayerInfoDao {
    Integer savePlayerInfo(PlayerInfo playerInfo);

    List<PlayerInfo> getPlayerInfoByCondition(Map<String, Object> map);

    Integer deleteById(Integer id);

    Integer updateById(PlayerInfo playerInfo);

}
