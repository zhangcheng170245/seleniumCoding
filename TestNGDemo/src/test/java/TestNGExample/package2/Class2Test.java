package TestNGExample.package2;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/11/011 15:26
 * @Version: 1.0
 */
public class Class2Test {

    @Test
    @Description("测试方法 在package1 下")
    public void testCaseB() {
        System.out.println("测试方法B在Class2Test下package2 下");
    }
}
