package com.example.nba;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.nba.dao.PlayerInfoDao;
import com.example.nba.model.PlayerInfo;
import com.example.nba.model.PlayerRecord;
import com.example.nba.model.Team;
import com.example.nba.service.PlayerInfoService;
import com.example.nba.service.PlayerRecordService;
import com.example.nba.service.TeamService;
import com.example.nba.util.DataUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NbaApplicationTests {
    @Autowired
    private PlayerInfoService playerInfoService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerRecordService playerRecordService;
    @Autowired
    private PlayerInfoDao playerInfoDao;

    @Test
    public void contextLoads() {
    }

    /**
     * 获取全部球员信息并存入数据库(由于直播吧的数据接口没有全部数据,只有按队别区分,所以麻烦一点)
     */
    @Test
    public void test1() throws IOException {
        for (int i = 1; i <= 30; i++) {
            Team team = teamService.getTeamById(i);
            Document document = Jsoup.connect("https://data.zhibo8.cc/manage/public/app.php?_url=/nba/player_list&alphabet=All&team=" + team.getTeamNameEn())
                    .ignoreContentType(true).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36")
                    .timeout(5000).get();
            JSONObject jsonObject = JSON.parseObject(document.text());
            JSONObject object = jsonObject.getJSONObject("data").getJSONObject("data");
            System.out.println("数据接口:    " + "https://data.zhibo8.cc/manage/public/app.php?_url=/nba/player_list&alphabet=All&team=" + team.getTeamNameEn());
            List<Map<String, Object>> mapList = (List) object.get("list");
            PlayerInfo playerInfo = null;
            System.out.println("===球队人数" + mapList.size() + "=============================排名" + i);
            for (int i1 = 0; i1 < mapList.size(); i1++) {
                {
                    System.out.println(mapList.get(i1).get("球员") +
                            " " + mapList.get(i1).get("名称") +
                            " " + mapList.get(i1).get("球队") +
                            " " + mapList.get(i1).get("位置") +
                            " " + mapList.get(i1).get("身高") +
                            " " + mapList.get(i1).get("体重") +
                            " " + mapList.get(i1).get("经验") +
                            " " + mapList.get(i1).get("国籍"));
                }
                playerInfoService.savePlayerInfo(new PlayerInfo(
                        20000 + 100 * i + i1,///球员数据库编码
                        team.getTeamNameEn(),//英文名称
                        mapList.get(i1).get("名称").toString(),
                        i+"",
                        DataUtil.getRoleID(mapList.get(i1).get("位置").toString()),
                        mapList.get(i1).get("身高").toString(),
                        mapList.get(i1).get("体重").toString(),
                        Integer.parseInt(mapList.get(i1).get("经验").toString()),
                        mapList.get(i1).get("国籍").toString(),
                        20000 + 100 * i + i1
                ));

            }

        }
    }


    /**
     * 获取球队数据并存储
     */
    @Test
    public void test2() throws IOException {
        Document document = Jsoup.connect("https://data.zhibo8.cc/manage/public/app.php?_url=/basketball/paihang")
                .ignoreContentType(true).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36")
                .timeout(5000).get();
        JSONObject jsonObject = JSON.parseObject(document.text());
        List list = (List) jsonObject.getJSONObject("data").getJSONObject("paihang").get("list");
        System.out.println(((JSONObject) list.get(0)).get("conference"));

       /*List<Map<String,Object>> map= (List)((JSONObject) list.get(0)).get("teams");//西部
        for (int i = 0; i <15; i++) {
            Team team = new Team();
            System.out.println(map.get(i).get("球队"));
            System.out.println(map.get(i).get("胜"));
            System.out.println(map.get(i).get("负"));
            System.out.println(map.get(i).get("排名"));
            team.setTeamId(i+1);
            team.setTeamNameEn(DataUtil.getTeamEnName(map.get(i).get("球队").toString()));
            team.setTeamNameCh(map.get(i).get("球队").toString());
            team.setZone(1);//1表示西部
            team.setVictory(Integer.parseInt(map.get(i).get("胜").toString()));
            team.setDefeat(Integer.parseInt(map.get(i).get("负").toString()));
            team.setRanking(Integer.parseInt(map.get(i).get("排名").toString()));
            teamService.insert(team);
        }
        System.out.println(map);*/


        List<Map<String, Object>> map = (List) ((JSONObject) list.get(1)).get("teams");//东部
        for (int i = 0; i < 15; i++) {
            Team team = new Team();
            System.out.println(map.get(i).get("球队"));
            System.out.println(map.get(i).get("胜"));
            System.out.println(map.get(i).get("负"));
            System.out.println(map.get(i).get("排名"));
            team.setTeamId(i + 16);//注意一下
            team.setTeamNameEn(DataUtil.getTeamEnName(map.get(i).get("球队").toString()));
            team.setTeamNameCh(map.get(i).get("球队").toString());
            team.setZone(2);//1表示西部
            team.setVictory(Integer.parseInt(map.get(i).get("胜").toString()));
            team.setDefeat(Integer.parseInt(map.get(i).get("负").toString()));
            team.setRanking(Integer.parseInt(map.get(i).get("排名").toString()));
            teamService.insert(team);
        }


    }

    /**
     * 通过条件查询
     */
    @Test
    public void test3() {
        Map<String, Object> map = new HashMap<>();
//        map.put("nameCh", "德克-诺维茨基");
        map.put("startPage",0);
        map.put("pageSize",5);
        System.out.println(map);
        List<PlayerInfo> info = playerInfoService.getPlayerInfoByCondition(map);
        for (PlayerInfo playerInfo : info) {
            System.out.println(playerInfo.toString());

        }
    }

    /**
     * 查询球员战绩
     */
    @Test
    public void test4() throws IOException {
        Document document = Jsoup.connect("https://data.zhibo8.cc/manage/public/app.php?_url=/nba/player_conditions")
                .ignoreContentType(true).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36")
                .timeout(5000).get();
        System.out.println("球员数据地址:   https://data.zhibo8.cc/nbaData/database/#/player_data");
        JSONObject jsonObject = new JSONObject();
        JSONObject s = JSON.parseObject(document.text());
        System.out.println(s);
        JSONObject jsonObject1 = s.getJSONObject("data").getJSONObject("data");
        System.out.println(jsonObject1);
        System.out.println(jsonObject1.get("items"));
        System.out.println(jsonObject1.get("list"));
        List<Map<String, Object>> mapListJson = (List) jsonObject1.get("list");
        System.out.println(mapListJson.size());//排名
        for (Map<String, Object> map : mapListJson) {
            System.out.print(map.get("排名") + "  ");//暂时当做ID
            System.out.print(map.get("球员") + "  ");
            System.out.print(map.get("得分") + "  ");
            System.out.print(map.get("篮板") + "  ");
            System.out.print(map.get("助攻") + "  ");
            System.out.print(map.get("抢断") + "  ");
            System.out.print(map.get("盖帽") + "  ");
            System.out.print(map.get("命中率") + "  ");
            System.out.print(map.get("分钟") + "  ");
            System.out.print(map.get("分钟") + "  " + "\n");

            Map<String, Object> map2 = new HashMap<>();
            System.out.println(map.get("球员"));
            map2.put("nameCh", map.get("球员"));//获取排行50强
            List<PlayerInfo> info = playerInfoService.getPlayerInfoByCondition(map2);
            System.out.println(info.size() + "----------------------------------------------");
            for (PlayerInfo playerInfo : info) {
                PlayerRecord playerRecord = new PlayerRecord(
                        playerInfo.getPlayerRecordId(),//查询数据库获取对应球员战绩ID
                        (String) map.get("球员"),
                        Integer.parseInt(map.get("排名").toString()),
                        Float.valueOf((String) map.get("得分")),
                        Float.valueOf((String) map.get("篮板")),
                        Float.valueOf((String) map.get("助攻")),
                        Float.valueOf((String) map.get("抢断")),
                        Float.valueOf((String) map.get("盖帽")),
                        Float.valueOf((String) map.get("失误")),
                        Float.valueOf((String) map.get("命中率")),
                        Float.valueOf((String) map.get("分钟")),
                        "https://data.zhibo8.cc/nbaData/database/#/player_data"
                );

                System.out.println(playerInfo.getPlayerRecordId());
                playerRecordService.savePlayerRecord(playerRecord);
            }


        }
    }
    @Test
    public void test5(){
        List<PlayerInfo> playerInfoByCondition = playerInfoService.getPlayerInfoByCondition(null);
        JSONArray jsonArray=new JSONArray();
        for (PlayerInfo playerInfo : playerInfoByCondition) {
//            JSONObject jsonObject=new JSONObject();

            jsonArray.add(playerInfo);
        }
        System.out.println(jsonArray);
    }

    @Test
    public void  test6(){
//        List<PlayerInfo> playerInfoByCondition = playerInfoService.getPlayerInfoByCondition(null);
//        System.out.println(playerInfoByCondition);
        List<PlayerInfo> playerInfoByCondition = playerInfoDao.getPlayerInfoByCondition(null);
        System.out.println(playerInfoByCondition);
    }



}

