package com.concurrent.demo.java8_TEST;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @ProjectName: demo
 * @Package: com.concurrent.demo.java8_TEST
 * @ClassName: java8_Stream
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/10/15 14:05
 * @Version: 1.0
 */

public class java8_Stream {
    public static void main(String[] args) {
        //List<String> list = Arrays.asList(new String[]{"aaa", "abc","ccc","aab","bbb","aba"});
        List<String> list = Arrays.asList(new String[]{"aaa", "abc","ccc","aab","bbb","aba"});
        boolean a = list.stream().noneMatch((s -> s.startsWith("hhh")));
        //test1(list);
        //test2(list,0,6);
        reduce(list);
        System.out.println(a);
    }

    //TODO 运用stream流排除不需要的数据，并排序
    public static void test1(List<String> list) {
        System.out.println(list);
        list = list.stream().filter(x->!x.equals("aaa")).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        }).collect(Collectors.toList());
        System.out.println(list);
    }

    //TODO 运用stream流排除不需要的数据，并分页显示
    public static void test2(List<String> list,int pageNow,int pageSize) {
        System.out.println(list);
        list = list.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        }).skip(pageNow).limit(pageSize).collect(Collectors.toList());
        //todo 把集合顺序翻转  Collections.reverse(list);
        System.out.println(list);
    }

    public static void reduce(List<String> list){
        Optional<String> reduce = list.stream().reduce((x, y) -> x+ " # " + y );
        String s = reduce.get();
        System.out.println(s);
        reduce.ifPresent(System.out::println);
    }

}
