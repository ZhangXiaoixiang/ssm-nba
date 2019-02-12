package com.example.nba.service;

import com.example.nba.dao.PlayerRecordDao;
import com.example.nba.dao.PlayerRoleDao;
import com.example.nba.model.PlayerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * PlayerRecordService
 *
 * @author 10905 2019/1/24
 * @version 1.0
 */
@Service
public class PlayerRecordService implements PlayerRecordDao {
    @Autowired
    private PlayerRecordDao playerRecordDao;
    @Override
    public List<PlayerRecord> getByCondition(Map<String, Object> map) {
        return playerRecordDao.getByCondition(map);
    }

    @Override
    public Integer savePlayerRecord(PlayerRecord playerRecord) {
        return playerRecordDao.savePlayerRecord(playerRecord);
    }
}
