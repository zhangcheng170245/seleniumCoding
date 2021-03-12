package JunitDemo5;

import org.junit.jupiter.api.RepeatedTest;
import util.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: zhangcheng
 * @Description: 多线程测试计算数据
 * @Date: 2021/3/11/011 11:32
 * @Version: 1.0
 */
public class Junit5Demo_4_2_Parallel {

    @RepeatedTest(10)
    public void add(){
        int result= Calculator.add(4,2);
        System.out.println(result);
        assertEquals(6,result);
    }


    @RepeatedTest(10)
    public void sub() throws InterruptedException {
        int result= Calculator.subtract(4,2);
        System.out.println(result);
        assertEquals(2,result);
    }


}
