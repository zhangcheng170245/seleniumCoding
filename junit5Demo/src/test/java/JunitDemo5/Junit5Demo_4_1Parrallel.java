package JunitDemo5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import util.Calculator;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/10/010 16:45
 * @Version: 1.0
 *   多线程执行的时候，@BeforeEach修饰的方法执行的时候与每个测试方法的顺序并不是串行的？
 */
public class Junit5Demo_4_1Parrallel {
    @BeforeEach
    void beforeEachTest(){
        Calculator.clear();
        System.out.println("测试前置");
    }
    @RepeatedTest(10)
    //@Test
    void countTest() throws InterruptedException{
          int result =Calculator.count(1);
          System.out.println(result);
   }

    @RepeatedTest(9)
    void countAtomicTest() throws InterruptedException{
        AtomicInteger result = Calculator.countAtomic(1);
        System.out.println(result);
    }
}
