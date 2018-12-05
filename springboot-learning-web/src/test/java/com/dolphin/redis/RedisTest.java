package com.dolphin.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangjichuan on 2018/11/18.
 */
public class RedisTest {

    @Test
    public void testSave() throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<1000;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Jedis jedis = new Jedis("127.0.0.1",6378);
                    for(int i=0;i<100000;i++){
                        jedis.set(i + ""+ Math.random(), i + "");

                    }
                    jedis.close();
                }
            });
        }

        Thread.currentThread().sleep(1000000L);
        executorService.shutdown();

    }
}
