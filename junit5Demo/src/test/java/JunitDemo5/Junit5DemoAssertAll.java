package JunitDemo5;

import org.junit.jupiter.api.Test;
import util.Calculator;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/10/010 16:12
 * @Version: 1.0
 */
public class Junit5DemoAssertAll {

    @Test  // 错误后依然继续执行
    public void addTest() {
        int resultPass = Calculator.add(4,2);
        int resultFail = Calculator.add(4,2);
        int result = Calculator.add(4,2);
        System.out.println("add:" + result);
        assertAll(("计算结果："),
                ()->assertEquals(6,resultPass),
                ()->assertEquals(7,resultFail),
                ()->assertEquals(8,result));
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
