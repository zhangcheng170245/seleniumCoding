package com.testcase.testcase1;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/9/009 23:45
 * @Version: 1.0
 */
public class Junit5Demo1Test {
    @Test
    void demo1(){
    System.out.println("com.testcase.testcase1.demo1的测试方法");
}

    @Test
    @Tag("testsuiteDemo")
    void demo2(){
        System.out.println("com.testcase.testcase1.demo2测试方法");
    }
}
