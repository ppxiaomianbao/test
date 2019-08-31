package com.concurrent.demo.final_test;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo.final_test
 * @ClassName: FinalTest1
 * @Author: limingxing
 * @Description: todo 测试不用final修饰符将对象变为不可变,用这种方式对象的属性也变得不可修改，这是guava里的api实现的
 * @Date: 2019/8/30 16:19
 * @Version: 1.0
 */
public class FinalTest2 {
    private static Map<Integer,Integer> mm = getMap();
    private static ImmutableBiMap<Integer,Integer> map = ImmutableBiMap.copyOf(mm);
    static {
        /*map.put(1,2);
        map.put(2,4);
        map.put(3,6);*/

    }

    private static Map<Integer,Integer> getMap(){
        mm = new HashMap<>();
        mm.put(1,3);
        mm.put(2,4);
        mm.put(3,6);
        return mm;
    }

    public static void main(String[] args) {
        System.out.println(map.toString());
        map.put(1,5);
        System.out.println(map.toString());
    }
}
