package com.example.nba.service;

import com.example.nba.dao.UserDao;
import com.example.nba.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * UserService
 *
 * @author 10905 2019/1/23
 * @version 1.0
 */
@Service
public class UserService implements UserDao {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByCondition(Map<String, Object> map) {
        if (null != map) {
            System.out.println("map为===>"+map);
            return userDao.getUserByCondition(map);
        } else {
            System.out.println("入参为空map");
            return null;
        }

    }
}
