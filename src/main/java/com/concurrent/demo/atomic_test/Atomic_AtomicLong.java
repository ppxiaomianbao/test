package com.concurrent.demo.atomic_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo.atomic_test
 * @ClassName: Atomic_AtomicLong
 * @Author: limingxing
 * @Description: todo 线程安全类测试
 * @Date: 2019/8/28 20:03
 * @Version: 1.0
 */
public class Atomic_AtomicLong {
    private final static Logger logger = LoggerFactory.getLogger(Atomic_AtomicLong.class);

    private final static AtomicLong atomicInt = new AtomicLong(0);

    public static void main(String[] args) throws InterruptedException {
        int total = 5000;
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0; i <total ; i++){
            executorService.execute(()->{
                add();
            });
        }
        Thread.sleep(300);
        executorService.shutdown();
        logger.warn("AtomicLong : {}" , atomicInt.get());
    }

    private static void add() {
        atomicInt.incrementAndGet();
    }


}
