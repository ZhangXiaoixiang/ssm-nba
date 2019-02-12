package com.example.nba.service;

import com.example.nba.dao.PlayerRoleDao;
import com.example.nba.model.PlayerRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * PlayerRoleDaoService
 *
 * @author 10905 2019/1/11
 * @version 1.0
 */
@Service
public class PlayerRoleService implements PlayerRoleDao {
    @Autowired
    private PlayerRoleDao playerRoleDao;
    @Override
    public List<PlayerRole> getPlayerRoleByCondition(Map<String, Object> map) {
        return playerRoleDao.getPlayerRoleByCondition(map);
    }
}
