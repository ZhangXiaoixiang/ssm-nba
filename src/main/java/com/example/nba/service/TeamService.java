package com.example.nba.service;

import com.example.nba.dao.TeamDao;
import com.example.nba.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * TeamService
 *
 * @author 10905 2019/1/8
 * @version 1.0
 */
@Service
public class TeamService implements TeamDao {
    @Autowired
    private TeamDao teamDao;
    @Override
    public Integer insert(Team team) {
        return teamDao.insert(team);
    }

    @Override
    public Team getTeamById(Integer id) {
        return teamDao.getTeamById(id);
    }

    @Override
    public List<Team> getTeamByCondition(Map<String, Object> map) {
        return teamDao.getTeamByCondition(map);
    }
}
