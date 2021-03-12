package TestNGExample;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import util.Calculator1;

/**
 * @Author: zhangcheng
 * @Description: testng 模拟多线程
 * @Date: 2021/3/11/011 17:30
 * @Version: 1.0
 */
public class TheardDemo {

    @Test(threadPoolSize = 2, invocationCount = 5)
    public void addTest() throws InterruptedException {
        SoftAssert assertion = new SoftAssert();
        int result = Calculator1.add(4,2);
        System.out.println("完成加法计算，结果为："+result);
        Assert.assertEquals(result ,6);
    }



}
