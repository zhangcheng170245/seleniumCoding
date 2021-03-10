package TestNGExample;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * @Author: zhangcheng
 * @Description: 装载后统一记录
 * @Date: 2021/3/9/009 17:20
 * @Version: 1.0
 */
public class orderPutrevTest_3 {
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
    @AfterMethod
    public void record() throws Exception {
        System.out.print("头盔哥统一记录 \n");
    }

}
