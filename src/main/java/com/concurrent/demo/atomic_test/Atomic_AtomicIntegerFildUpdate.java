package com.concurrent.demo.atomic_test;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo.atomic_test
 * @ClassName: Atomic_AtomicIntegerFildUpdate
 * @Author: limingxing
 * @Description: todo 替换if else
 * @Date: 2019/8/29 12:33
 * @Version: 1.0
 */
public class Atomic_AtomicIntegerFildUpdate {
    private volatile int count = 3;

    public int getCount() {
        return count;
    }

    private static AtomicIntegerFieldUpdater<Atomic_AtomicIntegerFildUpdate> atomic = AtomicIntegerFieldUpdater.newUpdater(Atomic_AtomicIntegerFildUpdate.class,"count");

    public static void main(String[] args) {
        Atomic_AtomicIntegerFildUpdate aa = new Atomic_AtomicIntegerFildUpdate();
        // todo 如果指定类的指定字段的值是0，则把这个字段修改为5
        atomic.compareAndSet(aa,0,5);
        System.out.println(aa.getCount());
    }
}
