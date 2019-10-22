package com.concurrent.demo.java8_TEST;

/**
 * @ProjectName: demo
 * @Package: com.concurrent.demo.java8_TEST
 * @ClassName: java8_variable
 * @Author: limingxing
 * @Description: todo java8 lambda表达式中访问成员变量或者静态变量
 *                                              todo 只能访问，不可修改
 * @Date: 2019/10/9 13:50
 * @Version: 1.0
 */
public class java8_variable {
    int outerNum;
    static int staticOuterNum;

    public static void main(String[] args) {
        java8_variable java8_variable = new java8_variable();
        java8_variable.testScopes();
    }

    public void testScopes(){
        Converter<String,Integer> staticConverter = (from) ->{
            staticOuterNum = 12;
            return Integer.valueOf(from);
        };
        Converter<String,Integer> converter = (from) ->{
            outerNum = 12;
            return Integer.valueOf(from);
        };
    }

}
