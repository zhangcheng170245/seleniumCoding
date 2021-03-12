package util;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

/**
 * @Author: zhangcheng
 * @Description: 计算器测试类
 * @Date: 2021/3/9/009 22:04
 * @Version: 1.0
 */
public class Calculator1 {
    //结果类
    private static int result = 0;
    private static AtomicInteger result2 = new AtomicInteger();


    public static AtomicInteger countAtomic(int x) throws InterruptedException {
        Thread.sleep(1000);
        result2.addAndGet(x);
        return result2;
    }


    public static int add(int x,int y){
        result = x + y;
        return result;
    }

    public static void clear(){
        result = 0;
        System.out.println("当前结果已清零！");
    }

    public static int count(int x) throws InterruptedException {
        int i = result;
        sleep(1000);
        result = i + x;
        return result;
    }

    public static synchronized int synCount(int x) throws InterruptedException {
        int i = result;
        sleep(1000);
        result = i + x;
        return result;
    }

    public static int subtract(int x,int y) throws InterruptedException {
        result = x - y;
        sleep(10);
        return result;
    }

    public static int multiply(int x,int y){
        result = x * y;
        return result;
    }

    public static int divide(int x,int y){
        result = x / y;
        return result;
    }
}