package com.concurrent.demo.singleton_enum;

/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo.singleton_enum
 * @ClassName: SingleTonEnum
 * @Author: limingxing
 * @Description: todo 用枚举类来实现单例模式
 * @Date: 2019/8/30 15:11
 * @Version: 1.0
 */
public class SingleTonEnum {
    private int s ;

    @Override
    public String toString() {
        return "SingleTonEnum{" +
                "s=" + s +
                '}';
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    private  SingleTonEnum(){
    }

    private SingleTonEnum(int s){
        this.s = s;
    }

    public static SingleTonEnum getInstance(){
        return Singleton.ERREO.getInstance();
    }

    enum Singleton {
        //INSTANCE;
        SUCCESS(
            12,13
        ),ERREO(
            21,22
                );

        private int ss;
        private int sss;

        public int getSs() {
            return ss;
        }

        public int getSss() {
            return sss;
        }

        private Singleton(int sss, int ss){
             this.ss = ss;
             this.sss = sss;
             singleTonEnum = new SingleTonEnum(ss);
         }
         private SingleTonEnum singleTonEnum = null;
         //todo jvm保证此函数只执行一次
         private Singleton(){
            singleTonEnum = new SingleTonEnum();
         }
         public SingleTonEnum getInstance(){
             return singleTonEnum;
         }
    }

    public static void main(String[] args) {
        System.out.println(SingleTonEnum.getInstance());
        System.out.println(SingleTonEnum.getInstance());
        System.out.println(SingleTonEnum.getInstance());
    }
}
