package com.concurrent.demo.java8_TEST;

import com.google.common.base.Converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ProjectName: demo
 * @Package: com.concurrent.demo.java8_TEST
 * @ClassName: Lambda_sort
 * @Author: limingxing
 * @Description: todo Lambda表达式简单实用之 排序
 * @Date: 2019/10/8 20:08
 * @Version: 1.0
 */
public class Lambda_sort {

    public static void main(String[] args) {
        Integer[] integers = IntStream.of(1, 6, 5, 3, 4).boxed().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }).collect(Collectors.toList()).toArray(new Integer[0]);
        System.err.println(Arrays.toString(integers));
        List<String> list = Arrays.asList("abC", "abF", "abH", "abD");
        System.out.println("sort -- start " + list);
        //list = java8_Start(list);

        //list = java8_Version1(list);
        list = java8_Version2(list);
        System.out.println("sort -- end " + list);
    }

    /**
     * @param list
     * @Method java8_Start
     * @Author limingxing
     * @Version 1.0
     * @Description todo java8之前对list排序常用方法
     * @Return java.util.List<java.lang.String>
     * @Exception
     * @Date 2019/10/8 20:14
     */
    public static List<String> java8_Start(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return list;

    }

    /**
     * @Method java8_Version1
     * @Author limingxing
     * @Version  1.0
     * @Description todo java8改进后可用写法
     * @param list
     * @Return java.util.List<java.lang.String>
     * @Exception
     * @Date 2019/10/8 20:18
     */
    public static List<String> java8_Version1(List<String> list) {
        Collections.sort(list, (String a, String b) ->
        {
            return a.compareTo(b);
        });
        return list;
    }

    /**
     * @Method java8_Version1
     * @Author limingxing
     * @Version  1.0
     * @Description todo java8改进后可用写法，并再次精简之后的写法
     * @param list
     * @Return java.util.List<java.lang.String>
     * @Exception
     * @Date 2019/10/8 20:18
     */
    public static List<String> java8_Version2(List<String> list) {
        Collections.sort(list, (a, b) ->a.compareTo(b));
        return list;
    }

}
