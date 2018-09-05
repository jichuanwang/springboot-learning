package com.dolphin.zklearn;

import org.I0Itec.zkclient.ZkClient;
import org.apache.curator.RetryPolicy;
import org.apache.curator.RetrySleeper;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author jichuan.wang
 * @<p>:
 * @since 2018/9/5 10:17
 */
public class ZKLearn3 {
    private ZooKeeper zooKeeper;

    @Before
    public void before() throws Exception{
        CuratorFramework frameworkFactory = CuratorFrameworkFactory.newClient("127.0.0.1:2181",new RetryPolicy(){
            @Override
            public boolean allowRetry(int i, long l, RetrySleeper retrySleeper) {
                System.out.println("次数="+i+"  耗时:"+l);
                return false;
            }
        });
        frameworkFactory.start();
    }

    @Test
    public void testInsert() throws Exception{
        String path =zooKeeper.create("/zkLearn","haha".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);
    }

    @Test
    public void testGet() throws Exception{
      /*  String path =zooKeeper.getData("/zkLearn", ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);*/
        ZkClient zkClient = new ZkClient("");
    }

    @Test
    public void testGetChild() throws Exception{
        List<String> children =zooKeeper.getChildren("/", true);
        System.out.println(children);
    }

    @Test
    public void testGetChildWatch() throws Exception{
        zooKeeper.getChildren("/zkLearn",true);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }

    @Test
    public void testSetData() throws Exception{
        zooKeeper.setData("/zkLearn","hello".getBytes(),-1);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }
}
