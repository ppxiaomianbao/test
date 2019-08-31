package com.concurrent.demo.atomic_test;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo.atomic_test
 * @ClassName: Atomic_AtomicReferenceFiledUpdater
 * @Author: limingxing
 * @Description: todo 可以修改某个类的某个属性
 * @Date: 2019/8/29 12:39
 * @Version: 1.0
 */
public class Atomic_AtomicReferenceFiledUpdater {
    public volatile String str = "";
    // todo 必须要volatile修饰并且不能是static修饰的字段才行，不然会报错
    private volatile Boolean b = false;

    public boolean isB() {
        return b;
    }

    public String getStr() {
        return str;
    }

    private static AtomicReferenceFieldUpdater<Atomic_AtomicReferenceFiledUpdater, Boolean> atomicReferenceFieldUpdater =
            AtomicReferenceFieldUpdater.newUpdater(Atomic_AtomicReferenceFiledUpdater.class,Boolean.class,"b");

    public static void main(String[] args) {
        Atomic_AtomicReferenceFiledUpdater aa = new Atomic_AtomicReferenceFiledUpdater();
        atomicReferenceFieldUpdater.compareAndSet(aa,aa.isB(),true);
        System.out.println(aa.isB());
    }
}
