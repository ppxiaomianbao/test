package com.concurrent.demo.final_test;

import com.google.common.collect.Maps;

import javax.rmi.CORBA.Util;
import java.util.Map;

/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo.final_test
 * @ClassName: FInalTest
 * @Author: limingxing
 * @Description: todo  测试用final修饰的变量，发现基本类型用final修饰，重新赋值编译都通不过，而引用类型的变量用final修饰之后只是不能修改引用，但是里面的属性是可以修改的
 * @Date: 2019/8/30 15:39
 * @Version: 1.0
 */
public class FInalTest {
    private static final int num = 10;
    private static final Map<Integer,Integer> map = Maps.newHashMap();
    static{
        map.put(1,2);
        map.put(2,4);
        map.put(3,6);
    }
    public static void main(String[] args) {
        map.put(1,5);
        System.out.println(map.toString());
        //map = Maps.newHashMap();
        //num = 5;
    }
}
