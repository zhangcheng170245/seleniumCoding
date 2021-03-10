package TestNGExample;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Author: zhangcheng
 * @Description: 依赖测试
 * @Date: 2021/3/9/009 17:36
 * @Version: 1.0
 */
public class orderDependencies {
    @Test
    public void putInA() throws Exception {
        System.out.print("装入坚果 A \n");
        Assert.fail("装配发生错误！");
    }

    @Test(dependsOnMethods = { "putInA" })
    public void putInB() throws Exception {
        System.out.print("装入坚果 B\n");

    }

    @Test(dependsOnMethods = { "putInB" })
    public void putInC() throws Exception {
        System.out.print("装入坚果 C\n");
    }

    @Test(dependsOnMethods = { "putInC" })
    public void putInD() throws Exception {
        System.out.print("装入坚果 D\n");

    }

    @Test(dependsOnMethods = { "putInD" })
    public void putInE() throws Exception {
        System.out.print("装入坚果 E\n");
    }
}