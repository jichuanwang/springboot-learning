package com.dolphin.learning.springboot.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created with IntelliJ IDEA.
 * Author: kai.zheng
 * Date: 2018/4/13 11:21
 * Description:
 */
@Configuration
//@ImportResource("classpath:spring-elastic-job.xml")
public class ElasticJobConfig {

   /* @Bean
    public JobScheduler getScheduler(){
        return new JobScheduler(createResistryCenter(),createJobConfiguration());
    }

    private static CoordinatorRegistryCenter createResistryCenter(){
        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(
                new ZookeeperConfiguration("localhost:2181","dd-job"));
        regCenter.init();
        return regCenter;
    }
    private static LiteJobConfiguration createJobConfiguration(){
        JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration.newBuilder("my-first-job",
                "0/15 * * * * ?",10).build();
        SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig, MyElasticJob.class.getCanonicalName());
        LiteJobConfiguration simpleJobRootConfig = LiteJobConfiguration.newBuilder(simpleJobConfig).build();

        return simpleJobRootConfig;
    }*/
}
