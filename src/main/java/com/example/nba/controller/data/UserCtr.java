package com.example.nba.controller.data;

import com.alibaba.fastjson.JSONObject;
import com.example.nba.model.User;
import com.example.nba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * UserCtr
 *
 * @author 10905 2019/1/23
 * @version 1.0
 */
@RestController
@RequestMapping("/data/user")
public class UserCtr implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @RequestMapping("/doLogin")
    public Object doLogin(String name, String pwd, HttpSession session) {


        Map<String, Object> map = new HashMap<>();
        map.put("userName", name);
        map.put("userPwd", pwd);
        User user = userService.getUserByCondition(map);
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> map2 = new HashMap<>();

        if (null != user) {
            //        session存放的地方
            session.setAttribute("userName", name);
            session.setAttribute("userPwd", pwd);
            session.setAttribute("user", user);
            System.out.println("登录成功!的session==>" + session);
//            设置session过期时间秒为单位
            session.setMaxInactiveInterval(30*60);
            //存放ajax反馈
            map2.put("state", "ok");
            jsonObject.put("result", map2);
            return map2;
        } else {
            map2.put("state", "error");
            jsonObject.put("result", map2);
            return map2;
        }
    }

}
