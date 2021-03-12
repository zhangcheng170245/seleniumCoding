package TestNGExample.package1;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/11/011 15:26
 * @Version: 1.0
 */
public class Class1Test {

    @Test(groups = {"group01"})
    @Description("测试方法1 在package1 下")
    public void testCaseA01() {
        System.out.println("测试方法1在Class1Test下package1 下");
    }
    @Test(groups = {"group02","group03"}) //或
    @Description("测试方法2在package1 下")
    public void testCaseA02() {
        System.out.println("测试方法2在Class2Test下package1 下");
    }
    @Test(groups = {"group03"})

    @Description("测试方法3在Class3Test下package1 下")
    public void testCaseA03() {
        System.out.println("测试方法3在Class3Test下package1 下");
    }
}
