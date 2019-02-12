package com.example.nba.controller.page;

import com.example.nba.model.PlayerInfo;
import com.example.nba.model.PlayerRole;
import com.example.nba.model.Team;
import com.example.nba.service.PlayerInfoService;
import com.example.nba.service.PlayerRoleService;
import com.example.nba.service.TeamService;
import com.example.nba.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PlayerPage
 *
 * @author 10905 2019/1/9
 * @version 1.0
 */
@Controller
@RequestMapping("sys/page/PlayerInfo")
public class PlayerInfoPage {
    @Autowired
    private PlayerInfoService playerInfoService;
    @Autowired
    private PlayerRoleService playerRoleService;
    @Autowired
    private TeamService teamService;





    @RequestMapping("/index")
    public String index(Model model,HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        List<PlayerInfo> players = playerInfoService.getPlayerInfoByCondition(map);
        List<Team> teamList = teamService.getTeamByCondition(null);
        System.out.println(teamList);
        List<PlayerRole> playerRoleList = playerRoleService.getPlayerRoleByCondition(null);
        System.out.println(playerRoleList);
        model.addAttribute("players", players);
        model.addAttribute("teamList", teamList);
        model.addAttribute("playerRoleList", playerRoleList);

        return "index";
    }

    /**
     * 去添加页时把数据填充到model,渲染模板再把model数据进行渲染把下拉框填充
     *
     * @param model
     * @return
     */
    @RequestMapping("/goAdd")
    public String goAdd(Model model,HttpSession session) {
        List<Team> teamList = teamService.getTeamByCondition(null);
        System.out.println(teamList);
        List<PlayerRole> playerRoleList = playerRoleService.getPlayerRoleByCondition(null);
        System.out.println(playerRoleList);
        model.addAttribute("teamList", teamList);
        model.addAttribute("playerRoleList", playerRoleList);
        model.addAttribute("user",session.getAttribute("user"));

        return "addPlayer";//没有提出公共部分
//        return "add";//缺样式的
    }

    @RequestMapping("/add")
    public String add(PlayerInfo playerInfo) {
        System.out.println("---------------add-------------------------------");
        System.out.println(playerInfo);
        playerInfoService.savePlayerInfo(playerInfo);
        //添加成功回首页
        return "redirect:http://localhost:8080/page/PlayerInfo/index";
    }
    @RequestMapping("/goUpdate")
    public String goUpdate(Model model,Integer id){
        System.out.println("---------------goUpdate-------------------------------");
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        List<PlayerInfo> playerInfoList = playerInfoService.getPlayerInfoByCondition(map);
        System.out.println(playerInfoList.size()+"[[[[[[[[[[[[[[[[[[[[[[[[[[[[");
        PlayerInfo playerInfo = playerInfoList.get(0);
        /**
         * 涉及到联表查询,为了展示数据,所以需要多放一些
         */
        List<Team> teamList = teamService.getTeamByCondition(null);


        System.out.println(teamList);
        List<PlayerRole> playerRoleList = playerRoleService.getPlayerRoleByCondition(null);
//        转换球队ID为Id数字
        playerInfo.setTeamId(DataUtil.getTeamID(playerInfo.getTeamId()).toString());
//        同上
        playerInfo.setPlayerRole(DataUtil.getRoleID(playerInfo.getPlayerRole()));

        model.addAttribute("teamList", teamList);
        model.addAttribute("playerRoleList", playerRoleList);
        model.addAttribute("playerInfo", playerInfo);

        return "updatePlayer";
    }
   @RequestMapping("/update")
    public String update(PlayerInfo playerInfo){

        playerInfoService.updateById(playerInfo);

        return "redirect:http://localhost:8080/page/PlayerInfo/index";
    }

    @RequestMapping("/common")
    public String common(HttpSession session,Model model){
        System.out.println("-----后台写的HTML公共部分(common/common)不是templates的情况------");

        model.addAttribute("user",session.getAttribute("user"));
        System.out.println("首页common的 session是: "+session.getAttribute("user"));
        return "common/common";
    }



}
