package com.concurrent.demo.TEST_test;

import java.util.Scanner;

/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo.TEST_test
 * @ClassName: System_In
 * @Author: limingxing
 * @Description: todo 控制台输入一组整数，输入0时程序结束并输出最大值与最小值
 * @Date: 2019/8/30 14:22
 * @Version: 1.0
 */
public class System_In {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int next,max = 0,min = 0;
        boolean flag = true;
        do{
            System.out.print("请输入一个整数(输入0结束):");
            next = scanner.nextInt();
            if(flag){
                max = next;
                min = next;
                flag = false;
            }
            if(next<min&&next!=0){
                min = next;
            }
            if(next>max&&next!=0){
                max = next;
            }
        }while (next!=0);
        System.out.println("最大值：" + max + "  最小值：" + min);
    }
}
