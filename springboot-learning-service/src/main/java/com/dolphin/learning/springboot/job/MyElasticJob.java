package com.dolphin.learning.springboot.job;


import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * @author jichuan.wang
 * @<p>:
 * @since 2018/9/11 13:01
 */
public class MyElasticJob implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        int shard = shardingContext.getShardingItem();
        int total = shardingContext.getShardingTotalCount();
        System.out.println("分片----------shard"+shard);
        System.out.println("分片----------total"+total);
    }
}
