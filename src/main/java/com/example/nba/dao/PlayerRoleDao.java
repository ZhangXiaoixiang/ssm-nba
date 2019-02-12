package com.example.nba.dao;

import com.example.nba.model.PlayerRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface PlayerRoleDao {
    List<PlayerRole> getPlayerRoleByCondition(Map<String,Object> map);


}