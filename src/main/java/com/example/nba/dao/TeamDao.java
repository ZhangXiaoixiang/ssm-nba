package com.example.nba.dao;

import com.example.nba.model.Team;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * TeamDao
 *
 * @author 10905 2019/1/8
 * @version 1.0
 */
@Mapper
public interface TeamDao {
    Integer insert(Team team);
    Team getTeamById(Integer id);
    List<Team> getTeamByCondition(Map<String,Object> map);
}
