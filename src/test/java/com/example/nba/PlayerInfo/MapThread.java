package com.example.nba.PlayerInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * MapThread
 *
 * @author 10905 2019/1/18
 * @version 1.0
 */
public class MapThread implements Runnable {
    private int age=10;
    private Map map;
    @Override
    public void run() {
        map=new HashMap();
        map.put(1,"张三");
        map.put(2,"李四");
        map.put(3,"王五");

//        System.out.println(map+"  age  "+age);


    }

    public Integer getAge() {
        return age;
    }
//同步
    public  void setAge(Integer age) {
        this.age = age;
    }
}
