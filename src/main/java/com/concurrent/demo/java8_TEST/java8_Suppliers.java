package com.concurrent.demo.java8_TEST;

import java.util.function.Supplier;

/**
 * @ProjectName: demo
 * @Package: com.concurrent.demo.java8_TEST
 * @ClassName: java8_Suppliers
 * @Author: limingxing
 * @Description: todo 使用此函数式接口创建的对象是多例的，暂时不知道能不能调用有参构造
 * @Date: 2019/10/9 15:00
 * @Version: 1.0
 */
public class java8_Suppliers {

    public static void main(String[] args) {
        Supplier<Test> testSupplier = Test::new;
        Test test = testSupplier.get();
        System.out.println(test);
    }
}

class Test{
    String name;
    String age;

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
