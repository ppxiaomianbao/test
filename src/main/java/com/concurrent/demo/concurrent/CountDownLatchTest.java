package com.concurrent.demo.concurrent;

import com.concurrent.demo.annotation.NotThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo.concurrent
 * @ClassName: CountDownLatch
 * @Author: limingxing
 * @Description: todo  并发测试类
 * @Date: 2019/8/27 10:23
 * @Version: 1.0
 */
@NotThreadSafe
public class CountDownLatchTest {
    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(CountDownLatchTest.class);
    //计算执行的次数
    private static int count = 0;

    //原子类，多线程高并发环境下用这个类可以避免数据错误
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    //最大并发数
    private static int threadTotal = 5000;

    //访问总数
    private static int clientTotal = 5000;

    public static void main(String[] args) throws InterruptedException {
        //创建可缓存的线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        Semaphore semaphore = new Semaphore(threadTotal);
        for (int i=0;i<clientTotal;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                    countDownLatch.countDown();
                } catch (Exception e) {
                    logger.info("exception",e);
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        logger.error("count:{}",atomicInteger.get());
    }

    private static void add(){
        atomicInteger.getAndIncrement();
    }
}
