package JunitDemo5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/10/010 16:02
 * @Version: 1.0
 */
public class Junit5_Nest {

    @DisplayName("重复执行")
    @RepeatedTest(value = 3,name = "{displayName},执行第{currentRepetition}次}")
    void repetition(){
        System.out.println("repetition");
    }

    @Nested
    @DisplayName("第二个执行")
    class TWO{
        @Test
        void putINTWO(){
            System.out.println("放入第二个箱子");
        }
    }
    //分组执行是从代码最后往前走
    @Nested
    @DisplayName("第一次执行")
    class One{
        @Test
        void putInONE(){
            System.out.println("放入第一个箱子");
        }
    }

}
