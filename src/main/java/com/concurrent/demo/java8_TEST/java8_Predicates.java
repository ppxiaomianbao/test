package com.concurrent.demo.java8_TEST;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import sun.invoke.empty.Empty;

import java.util.Objects;
import java.util.Properties;

/**
 * @ProjectName: demo
 * @Package: com.concurrent.demo.java8_TEST
 * @ClassName: java8_Perdicates
 * @Author: limingxing
 * @Description: todo predicate是一个布尔类型的函数，该函数只有一个输入参数，用来处理复杂的业务逻辑
 * @Date: 2019/10/9 14:05
 * @Version: 1.0
 */
public class java8_Predicates {

    public static void main(String[] args) {
        Predicate<String> predicate = s -> s.length() > 0;
        boolean apply = predicate.apply("12");
        System.out.println("判断字符串长度是否大于零：" + apply);
        //todo ==================================================================

        Predicate<String> predicatenonNull = Objects::nonNull;
        boolean nonNull = predicatenonNull.apply(null);
        System.out.println("判断字符串是否不为null：" + nonNull);
        //todo ==================================================================

        Predicate<String> predicateisNull = Objects::isNull;
        boolean isNull = predicateisNull.apply(null);
        System.out.println("判断字符串是否为null：" + isNull);
        //todo ==================================================================

        Predicate<String> predicateisEmpty = String::isEmpty;
        boolean isEmpty = predicateisNull.apply("");
        System.out.println("判断字符串是否不存在：" + isEmpty);
    }
}
