package com.concurrent.demo.TEST_test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo.TEST_test
 * @ClassName: Test
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/8/31 10:30
 * @Version: 1.0
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        countDownLatch.countDown();
        countDownLatch.await(300, TimeUnit.SECONDS);
    }
}
