package TestNGExample;

import org.testng.annotations.Test;

/**
 * @Author: zhangcheng
 * @Description: 顺序执行
 * @Date: 2021/3/9/009 17:16
 * @Version: 1.0
 */
public class orderTest_1 {
    @Test
    public void putInA() throws Exception {
        System.out.print("装入坚果 A \n");
    }
    @Test
    public void putInB() throws Exception {
        System.out.print("装入坚果 B\n");
    }
    @Test
    public void putInC() throws Exception {
        System.out.print("装入坚果 C\n");
    }
    @Test
    public void putInD() throws Exception {
        System.out.print("装入坚果 D\n");
    }
    @Test
    public void putInE() throws Exception {
        System.out.print("装入坚果 E\n");
    }

}
