package com.dolphin.zklearn;

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
public class ZKLearn {
    private ZooKeeper zooKeeper;

    @Before
    public void before() throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(1);
        zooKeeper = new ZooKeeper("127.0.0.1:2181", 1000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent);
                if(watchedEvent.getState() == Event.KeeperState.SyncConnected){
                    countDownLatch.countDown();
                }

                if(watchedEvent.getType() == Event.EventType.NodeChildrenChanged){
                    System.out.println("child changed");
                    try{
                        zooKeeper.getChildren(watchedEvent.getPath(),true);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

            }
        });
        countDownLatch.await();
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
