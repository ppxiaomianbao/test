package com.concurrent.demo.java8_TEST;

/**
 * @ProjectName: demo
 * @Package: com.concurrent.demo.java8_TEST
 * @ClassName: Formula
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/10/8 20:01
 * @Version: 1.0
 */
public interface Formula {

    double calulate(int a);

    /**
     * @Method sqrt
     * @Author limingxing
     * @Version  1.0
     * @Description todo 允许接口中有默认方法实现
     *        todo 这特特性别称为拓展方法
     * @param a
     * @Return double
     * @Exception
     * @Date 2019/10/8 20:02
     */
    default double sqrt(int a){
        return Math.sqrt(a);
    }

    //todo 测试！！！
    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calulate(int a) {
                return a * 100;
            }
        };
        System.out.println("formula -- sqrt " + formula.sqrt(100));
        System.out.println("formula -- calulate " + formula.calulate(10));
    }
}
