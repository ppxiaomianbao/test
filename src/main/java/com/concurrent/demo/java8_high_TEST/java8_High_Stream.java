package com.concurrent.demo.java8_high_TEST;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: demo
 * @Package: com.concurrent.demo.java8_high_TEST
 * @ClassName: java8_High_Stream
 * @Author: limingxing
 * @Description: todo collect 终止操作用法
 * @Date: 2019/10/24 12:46
 * @Version: 1.0
 */
public class java8_High_Stream {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 19),
                new Person("Pamela", 18),
                new Person("David", 20)
        );
        System.out.println(people);
        for (Person per : people) {
            System.err.println("hashcode :" + per.hashCode() + "  toString :" + per);
        }
        //todo 转换为set
        Set<Person> person = people.stream().filter(x -> x.getName().startsWith("P")).collect(Collectors.toSet());
        System.out.println(person);
        //todo 把获取的数据根据年龄分组并输出
        Map<Integer, List<Person>> collect = people.stream().collect(Collectors.groupingBy(x -> x.getAge()));
        collect.forEach((age, p) -> System.out.format("age %s  %s\n", age, p));

        //todo 因为流不能复用，所以用这种方法来获取同一个数据流
        Supplier<Stream<Person>> supplier = () -> people.stream();
        test_average(supplier);
    }

    /**
     * @param supplier
     * @Method test_average
     * @Author limingxing
     * @Version 1.0
     * @Description todo 测试聚合流上的元素
     * @Return void
     * @Exception
     * @Date 2019/10/25 16:14
     */
    public static void test_average(Supplier<Stream<Person>> supplier) {
        //获取平均年龄
        Double average = supplier.get().collect(Collectors.averagingDouble(x -> x.getAge()));
        System.out.println("test_average: " + average);

        IntSummaryStatistics collect = supplier.get().collect(Collectors.summarizingInt(x -> x.getAge()));
        System.out.println("test_average1: " + collect);

        //将所有人链接为一个字符串，没有参数就直接链接，三个参数表示任意两个对象用什么分隔，前缀和后缀
        String collect1 = supplier.get().map(x -> x.getName()).collect(Collectors.joining(" and ", "test", "or"));
        System.out.println("test_average2: " + collect1);
    }
}

//todo 测试用类
class Person {
    private String name;
    private int age;

    @Override
    public int hashCode() {
        return this.getName().hashCode() + this.getAge();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
