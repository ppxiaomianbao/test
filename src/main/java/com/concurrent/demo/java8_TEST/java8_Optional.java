package com.concurrent.demo.java8_TEST;

import java.util.Optional;

/**
 * @ProjectName: demo
 * @Package: com.concurrent.demo.java8_TEST
 * @ClassName: java8_Optional
 * @Author: limingxing
 * @Description: todo 防止产生空指针异常nullpointerexception，比较重要
 * @Date: 2019/10/10 15:13
 * @Version: 1.0
 */
public class java8_Optional {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("aaa");
    }
}
