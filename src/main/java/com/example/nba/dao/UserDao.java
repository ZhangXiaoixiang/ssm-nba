package com.example.nba.dao;


import com.example.nba.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserDao {
    User getUserByCondition(Map<String,Object> map);

}