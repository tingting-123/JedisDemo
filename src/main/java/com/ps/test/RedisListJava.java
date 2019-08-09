package com.ps.test;

import java.util.List;
import redis.clients.jedis.Jedis;

/**
 * @author gt
 * @description:  Redis Java List(列表) 实例
 * @create 2019/8/2
 */
public class RedisListJava {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //存储数据到列表中
        jedis.lpush("my-list", "xiaozhan");
        jedis.lpush("my-list", "wangyibo");
        jedis.lpush("my-list", "lixian");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }
    }
}