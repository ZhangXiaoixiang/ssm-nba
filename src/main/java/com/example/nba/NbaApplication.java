package com.example.nba;

import com.example.nba.config.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NbaApplication {



    public static void main(String[] args) {
        System.out.println("后台访问数据接口:  http://localhost:8080/sys/data/PlayerInfo/getPlayerInfoByCondition?startPage=1&pageSize=5");
        System.out.println("登录界面:  http://localhost:8080/page/user/login");
        System.out.println("登录成功首页:  http://localhost:8080/sys/page/PlayerInfo/index");
        SpringApplication.run(NbaApplication.class, args);
    }


}

