package com.concurrent.demo.sync_test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo.sync_test
 * @ClassName: SynchronizationTest
 * @Author: limingxing
 * @Description: todo 这两种运用方式只对当前调用的对象锁定，如果是不同的对象调用方法，则互不干扰
 * @Date: 2019/8/29 15:30
 * @Version: 1.0
 */
public class SynchronizationObjectTest {
    private static final Logger logger = LoggerFactory.getLogger(SynchronizationObjectTest.class);

    public void test1(int flag){
        synchronized (this){
            for(int i=0;i<10;i++){
                logger.info("test1 {} - {}" ,flag,i);
            }
        }
    }

    public synchronized void test2(int flag){
        for(int i=0;i<10;i++){
            logger.info("test2 {} - {}" ,flag,i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizationObjectTest synchronizationTest = new SynchronizationObjectTest();
        SynchronizationObjectTest synchronizationTest1 = new SynchronizationObjectTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            synchronizationTest.test1(1);
        });
        executorService.execute(()->{
            synchronizationTest.test1(2);
        });
        Thread.sleep(300);
        executorService.shutdown();
    }
}
