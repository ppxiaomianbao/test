package com.concurrent.demo.singleton_enum;

/**
 * @ProjectName: demo
 * @Package: com.concurrent.demo.singleton_enum
 * @ClassName: SingletonToEunm
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/10/3 14:39
 * @Version: 1.0
 */
public class SingletonToEunm {

    private SingletonToEunm(){ }

    public static SingletonToEunm getInstance(){
        return Singlee.INSTANCE.getInstance();
    }

    private enum Singlee{
        INSTANCE;
        private SingletonToEunm singletonToEunm;

        private Singlee(){singletonToEunm = new SingletonToEunm();}

        public SingletonToEunm getInstance(){
            return singletonToEunm;
        }
    }

    public static void main(String[] args) {
        System.out.println(SingletonToEunm.getInstance());
        System.out.println(SingletonToEunm.getInstance());
        System.out.println(SingletonToEunm.getInstance());
    }


}
