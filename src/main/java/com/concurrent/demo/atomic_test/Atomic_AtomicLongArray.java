package com.concurrent.demo.atomic_test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;

/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo.atomic_test
 * @ClassName: Atomic_AtomicLongArray
 * @Author: limingxing
 * @Description: todo 注意，此类的传入数组的修改不会影响原数组
 * @Date: 2019/8/29 13:09
 * @Version: 1.0
 */
public class Atomic_AtomicLongArray {
    private static long[] lon = new long[]{15L,65L,32L};
    private static AtomicLongArray atomicLongArray = new AtomicLongArray(lon);

    public static void main(String[] args) throws InterruptedException {
        atomicLongArray.compareAndSet(1,65,500);
        System.out.println(atomicLongArray.toString());
        System.err.println(Arrays.toString(lon));

    }
}
