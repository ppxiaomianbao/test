package com.concurrent.demo.atomic_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo.atomic_test
 * @ClassName: Atomic_AtomicBooleab
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/8/29 14:53
 * @Version: 1.0
 */
public class Atomic_AtomicBoolean {
    private final static Logger logger = LoggerFactory.getLogger(Atomic_AtomicBoolean.class);
    private static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<20;i++){
            executorService.execute(()->{
                test();
            });
        }
        Thread.sleep(300);
        executorService.shutdown();
    }

    public static void test(){
        if(atomicBoolean.compareAndSet(false,true)){
            logger.info("if 1 {}" , atomicBoolean);
        }else{
            atomicBoolean.compareAndSet(true,false);
        }
    }
}
