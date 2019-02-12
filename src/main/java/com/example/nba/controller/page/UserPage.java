package com.example.nba.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * UserPage
 *
 * @author 10905 2019/1/23
 * @version 1.0
 */
@Controller
@RequestMapping("page/user")
public class UserPage {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.removeAttribute("user");

        return "login";
    }

}
