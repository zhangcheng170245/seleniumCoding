package TestNGExample;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import util.Calculator1;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/11/011 17:59
 * @Version: 1.0
 */
public class TestNGDemo_6_1_Parameters {

    @Test(threadPoolSize = 1, invocationCount = 1)
    @Parameters({"x","y","result"})
    public void addTest(int x,int y,int result) throws InterruptedException {
        SoftAssert assertion = new SoftAssert();
        int result01 = Calculator1.add(x,y);
        System.out.println("完成加法计算，结果为："+result01);
        Assert.assertEquals(result,result01);
    }
}

