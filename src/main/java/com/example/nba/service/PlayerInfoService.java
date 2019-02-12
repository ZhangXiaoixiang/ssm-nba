package com.example.nba.service;

import com.example.nba.dao.PlayerInfoDao;
import com.example.nba.model.PlayerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * PlayerInfoService
 * 球员信息服务
 *
 * @author 10905 2019/1/8
 * @version 1.0
 */
@Service
@Transactional//事务
public class PlayerInfoService implements PlayerInfoDao {
    @Autowired
    private PlayerInfoDao playerInfoDao;

    @Override
    public Integer savePlayerInfo(PlayerInfo playerInfo) {


        return playerInfoDao.savePlayerInfo(playerInfo);
    }

    @Override
    public List<PlayerInfo> getPlayerInfoByCondition(Map<String, Object> map) {
        return playerInfoDao.getPlayerInfoByCondition(map);
    }

    @Override
    public Integer deleteById(Integer id) {
        return playerInfoDao.deleteById(id);
    }

    @Override
    public Integer updateById(PlayerInfo playerInfo) {
        System.out.println("\n---------------updateById-----------------");
        System.out.println("\nplayerInfo==>" + playerInfo);
        return playerInfoDao.updateById(playerInfo);
    }
}
