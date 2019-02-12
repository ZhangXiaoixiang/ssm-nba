package com.example.nba.PlayerInfo;

/**
 * TestMap
 *
 * @author 10905 2019/1/18
 * @version 1.0
 */
public class TestMap {
    public static void main(String[] args) {
        MapThread mapThread = new MapThread();
        MapThread mapThread2 = new MapThread();
        MapThread mapThread3 = new MapThread();
        System.out.println("没有修改是的年龄"+mapThread.getAge());
        System.out.println("没有修改是的年龄"+mapThread2.getAge());
        System.out.println("没有修改是的年龄"+mapThread3.getAge());
        mapThread2.setAge(20);
        mapThread3.setAge(30);


        Thread map1=new Thread(mapThread,"线程1---->");
        Thread map2=new Thread(mapThread2,"线程2====>");
        Thread map3=new Thread(mapThread3,"线程3====>");
//        System.out.println(map1.getName());
//        System.out.println(map2.getName());
//        System.out.println(map3.getName());



        map1.start();
        map2.start();
        map3.start();

        System.out.println("注意下面年龄不安全----------");

        System.out.println("被另一个线程修改后的年龄"+mapThread.getAge());
        System.out.println("被另一个线程修改后的年龄"+mapThread2.getAge());
        System.out.println("被另一个线程修改后的年龄"+mapThread3.getAge());


    }
}
