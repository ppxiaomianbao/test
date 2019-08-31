package com.concurrent.demo.sync_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo.sync_test
 * @ClassName: SynchronizationStaticTest
 * @Author: limingxing
 * @Description: todo 这两种运用方法锁住的整个类，所以不管调用哪个方法，都要等方法执行完才能执行这个类的下一个方法
 * @Date: 2019/8/29 15:42
 * @Version: 1.0
 */
public class SynchronizationStaticTest {
    private static final Logger logger = LoggerFactory.getLogger(SynchronizationStaticTest.class);

    public void test1(int flag) throws InterruptedException {
        synchronized (SynchronizationStaticTest.class){
            for(int i=0;i<10;i++){
                logger.info("test1 {} - {}" ,flag,i);
                Thread.sleep(300);
            }
        }
    }

    public static synchronized void test2(int flag){
        for(int i=0;i<10;i++){
            logger.info("test2 {} - {}" ,flag,i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizationStaticTest synchronizationTest = new SynchronizationStaticTest();
        SynchronizationStaticTest synchronizationTest1 = new SynchronizationStaticTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            try {
                synchronizationTest.test1(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(()->{
            synchronizationTest1.test2(2);
        });
        Thread.sleep(300);
        executorService.shutdown();
    }
}
