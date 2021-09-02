package easyRetry;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @ProjectName: coding
 * @Package: FailRetry
 * @ClassName: TestRetry
 * @Author: 还是那个橙子
 * @Description: 错误重拾的 案列
 * @Date: 2021/9/2 22:16
 * @Version: 1.0
 */

public class TestRetry {

    //@Test(retryAnalyzer = OverrideIReTry.class)
    @Test
    void  test(){
        Assert.assertTrue(10==11);
        System.out.println("我要起来");
    }
}
