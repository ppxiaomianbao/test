package com.concurrent.demo.singleton_enum;

import java.net.StandardSocketOptions;

/**
 * @ProjectName: demo
 * @Package: com.concurrent.demo.singleton_enum
 * @ClassName: Singleton1
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/10/21 12:27
 * @Version: 1.0
 */
public class Singleton1 {
    private static Singleton1 singleton1 = null;

    private Singleton1(){

    }

    public static Singleton1 getSingleton() {
        if (singleton1 == null) {
            synchronized (Singleton1.class) {
                if (singleton1 == null) {
                    singleton1 = new Singleton1();
                }
            }
        }
        return singleton1;
    }

    public static Singleton1 getInstance(){
        return singleEnum.INSTANCE.getSingleton1();
    }

    enum singleEnum{
        INSTANCE;
        Singleton1 singleton1;

        singleEnum(){
            singleton1 = new Singleton1();
        }

        public Singleton1 getSingleton1(){
            return singleton1;
        }
    }

    public static void main(String[] args) {
        System.out.println(Singleton1.getInstance());
        System.out.println(Singleton1.getInstance());
        System.out.println(Singleton1.getInstance());
    }
}
