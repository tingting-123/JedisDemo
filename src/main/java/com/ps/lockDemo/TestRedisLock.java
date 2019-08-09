package com.ps.lockDemo;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * @author gt
 * @description:  redisson实现分布式锁 使用 分布式锁(重试锁)
 * @create 2019/8/3
 */
public class TestRedisLock {
    @Autowired
    private RedissonClient client;

    public void testRedisLock() {
        RLock lock = client.getLock("pay");
        System.out.println(lock.isLocked());
        lock.lock(15L, TimeUnit.SECONDS);
        System.out.println(lock.isLocked());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    public void testRedisLock2(){
        System.out.println("2号正在拿锁....");
        RLock lock = client.getLock("pay");
        lock.lock(10L,TimeUnit.SECONDS);
        System.out.println("2号拿到了锁:"+lock.getName());

        lock.unlock();
    }
}
