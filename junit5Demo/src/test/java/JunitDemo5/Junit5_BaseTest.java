package JunitDemo5;

import org.junit.jupiter.api.Test;
import util.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: zhangcheng
 * @Description: 基础测试方法
 * @Date: 2021/3/9/009 22:08
 * @Version: 1.0
 */
public class Junit5_BaseTest {

    @Test
    public void addTest() {
        int result = Calculator.add(4,2);
        System.out.println("add:" + result);
        assertEquals(6,result);
    }
    @Test
    public void subtractTest() throws InterruptedException {
        int result = Calculator.subtract(4,2);
        System.out.println("subtract" + result);
        assertEquals(2,result);
    }

    @Test
    public void multiplyTest(){
        int result = Calculator.multiply(4,2);
        System.out.println("multiply" + result);
        assertEquals(8,result);
    }

    @Test
    public void divideTest(){
        int result = Calculator.divide(4,2);
        System.out.println("divide" + result);
        assertEquals(2,result);
    }

    @Test
    public void countTest() throws InterruptedException {
        int result = Calculator.count(4);
        System.out.println("count" + result);
        assertEquals(4,result);
    }
}