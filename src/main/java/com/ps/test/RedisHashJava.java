package com.ps.test;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gt
 * @description:  Redis Java hash 实例
 * @create 2019/8/2
 */
public class RedisHashJava {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");

        Map map = new HashMap();
        map.put("name","zhangsan");
        map.put("age","25");
        jedis.hmset("RedisHashKey",map);
        System.out.println("redis 存储的hash为："+jedis.hgetAll("RedisHashKey"));
    }
}
