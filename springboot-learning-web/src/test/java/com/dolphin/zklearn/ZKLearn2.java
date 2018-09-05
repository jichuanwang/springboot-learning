package com.dolphin.zklearn;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author jichuan.wang
 * @<p>:
 * @since 2018/9/5 10:17
 */
public class ZKLearn2 {
    private ZooKeeper zooKeeper;

    @Before
    public void before() throws Exception{
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
