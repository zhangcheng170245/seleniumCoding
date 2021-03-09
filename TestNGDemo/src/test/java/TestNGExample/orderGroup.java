package TestNGExample;

import org.testng.annotations.Test;

/**
 * @Author: zhangcheng
 * @Description: 组测试
 * @Date: 2021/3/9/009 17:26
 * @Version: 1.0
 */
public class orderGroup {

    @Test(groups = {"group01"})
    public void putInA() throws Exception {
        System.out.print("装入坚果 A \n");
    }

    @Test(groups = {"group01"})
    public void putInB() throws Exception {
        System.out.print("装入坚果 B\n");
    }

    @Test(groups = {"group01", "group02"})
    public void putInC() throws Exception {
        System.out.print("装入坚果 C\n");
    }

    @Test(groups = {"group02"})
    public void putInD() throws Exception {
        System.out.print("装入坚果 D\n");
    }

    @Test(groups = {"group02"})
    public void putInE() throws Exception {
        System.out.print("装入坚果 E\n");
    }
}
