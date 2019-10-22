package com.concurrent.demo.java8_TEST;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @ProjectName: demo
 * @Package: com.concurrent.demo.java8_TEST
 * @ClassName: java8_IntStream
 * @Author: limingxing
 * @Description: todo 基本类型的数据流
 *      //todo java8提供了用于处理基本类型的流对象IntStream，LongStream，DoubleStream
 * @Date: 2019/10/21 16:52
 * @Version: 1.0
 */
public class java8_IntStream {

    public static void main(String[] args) {
        //test_findFirst();
        //test_of_stream();
        //test_range();
        //test_average();
        //test_ObjectToBasic();
        test_BasicToObject();
    }

    // todo 获取集合流里的第一个元素
    public static void test_findFirst(){
        List<String> list = Arrays.asList("aa", "bb", "cc");
        Optional<String> findFirst = list.stream().findFirst();
        boolean present = findFirst.isPresent();
        System.out.println(present);
        System.out.println(findFirst.get());
    }

    //todo 数组转集合，在运用stream进行操作
    //todo 只要使用stream.of（）,就可以从一系列对象中创建数据流
    public static void test_of_stream(){
        Stream<String> stringStream = Stream.of("aa", "bb", "cc").map(x -> x.toUpperCase());
        List<String> collect = stringStream.collect(Collectors.toList());
        String[] strings = collect.toArray(new String[collect.size()]);
        System.out.println("array :" + Arrays.toString(strings));
        System.out.println("list : " + collect);
    }

    //todo java8 中运用基本类型流对象替换for循环
    public static void test_range(){
        IntStream range = IntStream.range(0, 5);
        range.forEach(x-> System.out.println(x));
    }

    //todo 在java8 stream流中使用求平均值的函数
    public static void test_average(){
        double asDouble = Arrays.stream(new int[]{1, 2, 3}).average().getAsDouble();
        System.out.println("average: " +asDouble);

        List<Integer> collect = IntStream.of(1, 3, 5).boxed().collect(Collectors.toList());
        System.out.println(collect);

        List<Long> collect1 = LongStream.of(1, 3, 5).boxed().collect(Collectors.toList());
        System.out.println(collect1);
    }

    //todo 将对象数据流映射为基本类型的数据流
    public static void test_ObjectToBasic(){
        OptionalInt max = Stream.of("a3", "a1", "a5").map(x -> x.substring(1)).mapToInt(Integer::valueOf).max();
        System.out.println(max.getAsInt());
    }

    //todo 将基本类型数据流映射为对象类型的数据流
    public static void test_BasicToObject(){
        IntStream.of(1,5,7).mapToObj(String::valueOf).map(x->x + "#").forEach(System.out::println);
    }
}
