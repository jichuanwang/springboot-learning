package com.dolphin.elasticjob;

import com.dolphin.learning.springboot.job.MyElasticJob;
import io.elasticjob.lite.api.JobScheduler;
import io.elasticjob.lite.config.JobCoreConfiguration;
import io.elasticjob.lite.config.LiteJobConfiguration;
import io.elasticjob.lite.config.simple.SimpleJobConfiguration;
import io.elasticjob.lite.event.rdb.JobEventRdbConfiguration;
import io.elasticjob.lite.internal.schedule.JobScheduleController;
import io.elasticjob.lite.reg.base.CoordinatorRegistryCenter;
import io.elasticjob.lite.reg.zookeeper.ZookeeperConfiguration;
import io.elasticjob.lite.reg.zookeeper.ZookeeperRegistryCenter;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.util.concurrent.CountDownLatch;

/**
 * @author jichuan.wang
 * @<p>:
 * @since 2018/9/11 13:53
 */
public class ElasticJobTest {

    public static void main(String[] args) throws Exception{
        DataSource dataSource = new BasicDataSource();
//        dataSource.se
        new JobScheduler(createResistryCenter(),createJobConfiguration(),new JobEventRdbConfiguration(dataSource));
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }

    public static CoordinatorRegistryCenter createResistryCenter(){
        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(
                new ZookeeperConfiguration("localhost:2181","dd-job"));
        regCenter.init();
        return regCenter;
    }
    public static  LiteJobConfiguration createJobConfiguration(){
        JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration.newBuilder("my-first-job",
                "0/15 * * * * ?",10).build();
        SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig, MyElasticJob.class.getCanonicalName());
        LiteJobConfiguration simpleJobRootConfig = LiteJobConfiguration.newBuilder(simpleJobConfig).build();

        return simpleJobRootConfig;
    }
}
