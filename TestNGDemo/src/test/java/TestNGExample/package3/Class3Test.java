package TestNGExample.package3;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/11/011 15:26
 * @Version: 1.0
 */
public class Class3Test {

    @Test
    @Description("测试方法 在package1 下")
    public void testCaseC() {
        System.out.println("测试方法C在Class3Test下package3 下");
    }

}
