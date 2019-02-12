package com.example.nba.util;

import java.util.HashMap;
import java.util.Map;

/**
 * TeamUtil
 *
 * @author 10905 2019/1/8
 * @version 1.0
 */

public class DataUtil {
    /**
     * 球队表和球员所属球队对应表
     *
     * @param teamName
     * @return
     */
    public static Integer getTeamID(String teamName) {
        Map<String, Integer> map = new HashMap();
        map.put("掘金", 1);
        map.put("勇士", 2);
        map.put("雷霆", 3);
        map.put("快船", 4);
        map.put("火箭", 5);
        map.put("马刺", 6);
        map.put("开拓者", 7);
        map.put("湖人", 8);
        map.put("国王", 9);
        map.put("爵士", 10);
        map.put("森林狼", 11);
        map.put("鹈鹕", 12);
        map.put("灰熊", 13);
        map.put("独行侠", 14);
        map.put("太阳", 15);
        map.put("雄鹿", 16);
        map.put("猛龙", 17);
        map.put("步行者", 18);
        map.put("76人", 19);
        map.put("凯尔特人", 120);
        map.put("热火", 21);
        map.put("黄蜂", 22);
        map.put("篮网", 23);
        map.put("活塞", 24);
        map.put("魔术", 25);
        map.put("奇才", 26);
        map.put("老鹰", 27);
        map.put("公牛", 28);
        map.put("尼克斯", 29);
        map.put("骑士", 30);
        return map.get(teamName);
    }

    /**
     * 球员角色对应
     *
     * @param roleName
     * @return
     */
    public static String getRoleID(String roleName) {
        Map<String, String> map = new HashMap();
        map.put("前锋", "1");
        map.put("前锋-后卫", "1");
        map.put("前锋-中锋", "1");
        map.put("中锋", "2");
        map.put("中锋-前锋", "2");
        map.put("后卫", "3");
        map.put("后卫-前锋", "3");

        return map.get(roleName);
    }

    public static String getTeamEnName(String teamChName) {
        Map<String, String> map = new HashMap();
        map.put("掘金", "nuggets");
        map.put("勇士", "warriors");
        map.put("雷霆", "thunder");
        map.put("快船", "clippers");
        map.put("火箭", "rockets");
        map.put("马刺", "spurs");
        map.put("开拓者", "blazers");
        map.put("湖人", "lakers");
        map.put("国王", "kings");
        map.put("爵士", "jazz");
        map.put("森林狼", "timberwolves");
        map.put("鹈鹕", "pelicans");
        map.put("灰熊", "grizzlies");
        map.put("独行侠", "mavericks");
        map.put("太阳", "suns");
        map.put("雄鹿", "bucks");
        map.put("猛龙", "raptors");
        map.put("步行者", "pacers");
        map.put("76人", "sixers");
        map.put("凯尔特人", "celtics");
        map.put("热火", "heat");
        map.put("黄蜂", "hornets");
        map.put("篮网", "nets");
        map.put("活塞", "pistons");
        map.put("魔术", "magic");
        map.put("奇才", "wizards");
        map.put("老鹰", "hawks");
        map.put("公牛", "bulls");
        map.put("尼克斯", "knicks");
        map.put("骑士", "cavaliers");
        return map.get(teamChName).toString();
    }

    public static void main(String[] args) {
        String s = DataUtil.getTeamEnName("步行者");
        System.out.println(s);
    }


}
