package com.ps.test;

import redis.clients.jedis.Jedis;

/**
 * @author gt
 * @description:  Redis Java 设置有序集合 实例
 * @create 2019/8/2
 */
public class RedisOrderlyJava {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");

        //设置有序集合
        jedis.zadd("javaKey5",0,"aaa");
        jedis.zadd("javaKey5",1,"bbb");
        jedis.zadd("javaKey5",2,"ccc");
        jedis.zadd("javaKey5",3,"ddd");
        //score 可以当做下标使用，min为score的最小值，max为score的最大值
        System.out.println("redis 存储的有序集合为："+jedis.zrangeByScore("javaKey5",0,3));
    }
}
