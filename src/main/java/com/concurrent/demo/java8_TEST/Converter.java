package com.concurrent.demo.java8_TEST;

/**
 * @ProjectName: demo
 * @Package: com.concurrent.demo.java8_TEST
 * @ClassName: Converter
 * @Author: limingxing
 * @Description: todo java8函数式接口,只允许有一个抽象方法，但是可以有多个默认方法，可以直接调用
 * @Date: 2019/10/8 20:22
 * @Version: 1.0
 */
//todo 注意：此注解表示接口里只能有一个抽象方法，是java8为函数式编程创建的,为了减少容错，不用此注解也可以
//todo 推荐使用
@FunctionalInterface
public interface Converter<F,T> {
    T convert(F from);

    default void defaultTest(){
        System.out.println("defaultTest!!!");
    }
}
