package com.concurrent.demo.TEST_test;

import ch.qos.logback.core.util.TimeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo.TEST_test
 * @ClassName: Test
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/8/31 10:30
 * @Version: 1.0
 */
public class Test {

    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static int count;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(20);
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        increement();
                        semaphore.release();
                        countDownLatch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("int :" + atomicInteger.get());
    }

    public static void increement() {
        //count++;
        atomicInteger.incrementAndGet();
    }
}
