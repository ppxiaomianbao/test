package com.concurrent.demo.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @ProjectName: demo
 * @Package: com.concurrent.demo.concurrent
 * @ClassName: ExecutorServiceTest
 * @Author: limingxing
 * @Description: todo 测试线程类的三个主要方法shutDown    shutDownNow     awitTran
 *               todo shutdown 方法调用完之后没完成的线程继续执行，不能再添加新的任务
 *                    shutdown 方法调用完之后直接中断没完成的任务，不能添加新任务
 *                    awaitTermination(3, TimeUnit.SECONDS) 阻塞，有两个参数，设置超时时间的，如果任务全都完成了，返回true，如果任务超过时间还没完成，返回false，可以继续添加新任务
 * @Date: 2019/10/17 9:03
 * @Version: 1.0
 */
public class ExecutorServiceTest {
    private final static Map<String,String> map = new ConcurrentHashMap<>(2,1);

    public static void main(String[] args) throws ExecutionException {
        List<Future<Map<String, String>>> list = new ArrayList<>(2);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Map<String, String>> submit = executorService.submit(new Callable<Map<String, String>>() {
            @Override
            public Map<String, String> call() throws Exception {
                map.put("test1", "thread_1");
                return map;
            }
        });
        list.add(submit);
        Future<Map<String, String>> submit1 = executorService.submit(new Callable<Map<String, String>>() {
            @Override
            public Map<String, String> call() throws Exception {
                TimeUnit.SECONDS.sleep(5000);
                map.put("test2", "thread_2");
                return map;
            }
        });
        list.add(submit1);
        try {
            executorService.shutdown();
            if(!executorService.awaitTermination(3, TimeUnit.SECONDS)){
                System.out.println("线程已超时：：：：");
                executorService.shutdownNow();
            }
            int size = list.size();
            System.out.println("list: " + list + size);
            List<Map<String,String>> result = new ArrayList<>();
            for(Future<Map<String, String>> li:list){
                result.add(li.get());
            }
            System.out.println("result: " + result);
            System.out.println(list);
        } catch (InterruptedException e) {
            System.out.println("进入异常：：；");
            e.printStackTrace();
            executorService.shutdownNow();
        }
        System.out.println(list);
    }
}
