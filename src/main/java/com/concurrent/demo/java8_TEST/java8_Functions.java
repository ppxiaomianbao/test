package com.concurrent.demo.java8_TEST;

import java.util.function.Function;

/**
 * @ProjectName: demo
 * @Package: com.concurrent.demo.java8_TEST
 * @ClassName: java8_Functions
 * @Author: limingxing
 * @Description: todo Functinos 接口接受一个参数，并返回单一结果，默认可以将多个函数串在一起（compse，andThen）
 * @Date: 2019/10/9 14:42
 * @Version: 1.0
 */
public class java8_Functions {

    public static void main(String[] args) {
        Function<String,Integer> function = Integer::valueOf;
        Function<String, String> stringStringFunction = function.andThen(String::valueOf);
        String apply = stringStringFunction.apply("123");
        System.out.println(apply);
    }
}
