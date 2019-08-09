package com.ps.test;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gt
 * @description:  Redis Java 设置无序集合 实例
 * @create 2019/8/2
 */
public class RedisUnorderedJava {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");

        jedis.sadd("javaKey4","aaa","bbb","bbb","sdfsf","ccc");  //重复值只会增加一个
        System.out.println("redis 存储的无序集合为："+jedis.smembers("javaKey4"));
    }
}
