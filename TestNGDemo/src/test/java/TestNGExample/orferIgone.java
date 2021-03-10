package TestNGExample;

import org.testng.annotations.Test;

/**
 * @Author: zhangcheng
 * @Description: 忽略测试
 * @Date: 2021/3/9/009 17:25
 * @Version: 1.0
 */
public class orferIgone {
    @Test
    public void putInA() throws Exception {
        System.out.print("装入坚果 A \n");
    }
    @Test
    public void putInB() throws Exception {
        System.out.print("装入坚果 B\n");
    }
    @Test(enabled=false)
    public void putInC() throws Exception {
        System.out.print("装入坚果 C\n");
    }
    @Test(enabled=false)
    public void putInD() throws Exception {
        System.out.print("装入坚果 D\n");
    }
    @Test
    public void putInE() throws Exception {
        System.out.print("装入坚果 E\n");
    }
}
