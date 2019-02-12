package com.example.nba.dao;

import com.example.nba.model.PlayerRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface PlayerRecordDao {
    List<PlayerRecord> getByCondition(Map<String, Object> map);

    Integer savePlayerRecord(PlayerRecord playerRecord);
}