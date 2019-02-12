package com.example.nba.PlayerInfo;

import com.example.nba.service.PlayerInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test01
 *
 * @author 10905 2019/1/10
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test01 {
    @Autowired
    private PlayerInfoService playerInfoService;
    @Test
    public void test1(){
        Integer integer = playerInfoService.deleteById(2);
        System.out.println(integer);
    }
}
