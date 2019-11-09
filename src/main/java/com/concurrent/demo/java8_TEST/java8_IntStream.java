package com.concurrent.demo.java8_TEST;

import java.io.EOFException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
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

    public static void main(String[] args) throws InterruptedException {
        //test_findFirst();
        //test_of_stream();
        //test_range();
        //test_average();
        //test_ObjectToBasic();
        //test_BasicToObject();
        //test_process();
        test_streamBreak();
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

        List<String> collect = Stream.of(1.0, 5.0, 4.0, 3.0).map(x -> x + "!").collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void test_process() throws InterruptedException {
        Stream<String> stringStream = Stream.of("aa", "bb", "cc", "dd").filter(x -> {
            System.out.println(x);
            return true;
        });//todo 上面这段代码不会打印任何数据，是因为衔接操作只在调用终止操作是执行，看下例的拓展

        stringStream.forEach(System.out::println);//todo 得到的输出可以看出首先执行的是filter然后是foreach，并且是一个接着一个的执行

        System.err.println("==================================================");
        Thread.sleep(300);
        Stream.of("a3", "b4", "h5").map(x -> {
            System.out.println("map : " + x);
            return x.toUpperCase();
        }).anyMatch(x -> {
            System.out.println("anymatch : " + x);
            return x.startsWith("B");
        });//todo 可以看到找到了符合的就停止了执行，不需要全都遍历一遍
        System.out.println("a".equalsIgnoreCase("A")); //忽略大小写的判断

        System.err.println("==================顺序的重要性====================");
        Thread.sleep(300);
        Stream.of("a2", "b2", "c5", "a3", "h2").map(x -> {
            System.out.println("map " + x);
            return x.toUpperCase();
        }).filter(x -> {
            System.out.println("filter " + x);
            return x.startsWith("C");
        }).forEach(x -> {
            System.out.println("forEach " + x);
        });//todo 可以看到结果map和filter都执行了五次，而foreach只执行了一次，再看下例，只是修改一下执行顺序

        System.err.println("==============>修改执行顺序后的测试");
        Thread.sleep(300);
        Stream.of("a2", "b2", "c5", "a3", "h2").filter(x -> {
            System.out.println("filter " + x);
            return x.startsWith("c");
        }).map(x -> {
            System.out.println("map " + x);
            return x.toUpperCase();
        }).forEach(x -> {
            System.out.println("forEach " + x);
        });//todo 可以看到修改执行顺序之后执行次数少了很多次
        //todo 在整合复杂的方法链时要注意方法的调用顺序

        System.err.println("==================添加sorted再次测试====================");
        Thread.sleep(300);
        Stream.of("a2", "b2", "c5", "a3", "h2").sorted((x, y) -> {
            System.out.printf("sorted : %s  %s\n", x, y);
            return x.compareTo(y);
        }).filter(x -> {
            System.out.println("filter " + x);
            return x.startsWith("c");
        }).map(x -> {
            System.out.println("map " + x);
            return x.toUpperCase();
        }).forEach(x -> {
            System.out.println("forEach " + x);
        });//todo 可以看到排序会消耗极大的性能

        System.err.println("==================添加sorted修改顺序再次测试====================");
        Thread.sleep(300);
        Stream.of("a2", "b2", "c5", "a3", "h2").filter(x -> {
            System.out.println("filter " + x);
            return x.startsWith("c");
        }).sorted((x, y) -> {
            System.out.printf("sorted : %s  %s\n", x, y);
            return x.compareTo(y);
        }).map(x -> {
            System.out.println("map " + x);
            return x.toUpperCase();
        }).forEach(x -> {
            System.out.println("forEach " + x);
        });//todo 正确的执行顺序可以极大的提升代码的执行效率

    }

    //TODO 因为java8的流不能被复用，一旦调用了任何终止操作，数据流就关闭了，如果需要多次用到数据流，就需要创建一个数据流供应器
    public static void test_streamBreak() {
        Supplier<Stream<String>> streamSupplier = () -> Stream.of("aa", "bb", "cc").filter(x -> x.startsWith("a"));
        System.out.println(streamSupplier.get().anyMatch(x -> true));
        System.out.println(streamSupplier.get().allMatch(x -> true));
    }

}
