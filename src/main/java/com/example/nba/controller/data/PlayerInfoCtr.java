package com.example.nba.controller.data;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.nba.dao.UserDao;
import com.example.nba.model.PlayerInfo;
import com.example.nba.model.PlayerRole;
import com.example.nba.model.Team;
import com.example.nba.model.User;
import com.example.nba.service.PlayerInfoService;
import com.example.nba.service.PlayerRoleService;
import com.example.nba.service.TeamService;
import com.example.nba.service.UserService;
import com.example.nba.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PlayerInfoCtr
 *
 * @author 10905 2019/1/9
 * @version 1.0
 */
//ajax更改跨域注解

@RestController
@RequestMapping("sys/data/PlayerInfo/")
public class PlayerInfoCtr {
    @Autowired
    private PlayerInfoService playerInfoService;
    @Autowired
    private PlayerRoleService playerRoleService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private UserService userService;
//    分页总数实现无刷新
//    Integer count=playerInfoService.getPlayerInfoByCondition(null).size();





    /**
     * layui分页没有采用restAPI形式
     *
     * @param startPage
     * @param pageSize
     * @return
     */
//    @CrossOrigin(origins = "http://127.0.0.1:8080")
    @RequestMapping(value = "/getPlayerInfoByCondition")
    public Object getPlayerInfoByCondition(Integer startPage, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("startPage", (startPage - 1) * pageSize);
        map.put("pageSize", pageSize);
        //获取分页的数据
        List<PlayerInfo> playerInfoList = playerInfoService.getPlayerInfoByCondition(map);
        System.out.println(playerInfoList);
        //构造分页json
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", playerInfoService.getPlayerInfoByCondition(null).size());
        map.put("data", playerInfoList);
        System.out.println(map);
        return map;

    }

    /**
     * 根据ID查询球员
     */
    @RequestMapping(value = "/getInfo/{id}", method = RequestMethod.GET)
    public Object getInfo(@PathVariable("id") Integer id, Model model) {
        System.out.println("==========ajax  " + id);
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        List<PlayerRole> playerRoleList = playerRoleService.getPlayerRoleByCondition(null);
        List<Team> teamList = teamService.getTeamByCondition(null);
        PlayerInfo playerInfo = (playerInfoService.getPlayerInfoByCondition(map)).get(0);


        JSONObject jsonObject = new JSONObject();


        jsonObject.put("playerRoleList", playerRoleList);
        jsonObject.put("teamList", teamList);
        jsonObject.put("playerInfo", playerInfo);
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        System.out.println("=====>json数据  " + jsonArray);
        System.out.println("=====>jsonObject  " + jsonObject);


//        return jsonObject;
        return jsonArray;

    }

    @RequestMapping("/addPlayerInfo")
    public Object addPlayerInfo(PlayerInfo playerInfo) {
        System.out.println("===>增加球员=====" + playerInfo);
        Integer integer = playerInfoService.savePlayerInfo(playerInfo);
        JSONObject josn = new JSONObject();
        if (integer == 1) {
            josn.put("result", "ok");
            return josn;
        } else {
            josn.put("result", "error");
            return josn;
        }

    }

    @RequestMapping("/delete/{id}")
    public Object delete(@PathVariable("id") Integer id) {
        Integer integer = playerInfoService.deleteById(id);
        JSONObject josn = new JSONObject();
        if (integer == 1) {
            josn.put("delete", "ok");
            return josn;
        } else {
            josn.put("delete", "error");
            return josn;
        }

    }


}
