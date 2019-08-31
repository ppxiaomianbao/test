package com.concurrent.demo.atomic_test;


import java.util.concurrent.atomic.AtomicReference;

/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo.atomic_test
 * @ClassName: Atomic_AtomicReference
 * @Author: limingxing
 * @Description: todo 替换if else
 * @Date: 2019/8/29 12:24
 * @Version: 1.0
 */
public class Atomic_AtomicReference {
    private int count;

    public int getCount() {
        return count;
    }

    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(0);

    public static void main(String[] args) {
        // todo 如果是0就修改为5
        atomicReference.compareAndSet(0,5);
        atomicReference.compareAndSet(1,9);
        atomicReference.compareAndSet(5,1);
        atomicReference.compareAndSet(3,8);
        System.out.println(atomicReference.get());
    }
}
