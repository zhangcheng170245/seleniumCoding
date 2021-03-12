package TestNGExample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.Calculator1;
import util.FakerUtils;

import java.io.IOException;

/**
 * @Author: zhangcheng
 * @Description: 数据驱动
 * @Date: 2021/3/11/011 21:37
 * @Version: 1.0
 */
public class TestNGDemo_6_2_Dataprovider {

    //定义数据提供者
    @DataProvider(name = "testData")
    public static Object[][] words() throws IOException {
        return FakerUtils.getTestData("/src/main/resources/data/datademo.csv");
    }

    @Test(threadPoolSize = 1, invocationCount = 1, dataProvider = "testData")
    public void divTest(String x ,String y) throws InterruptedException {
        int result = Calculator1.divide(Integer.valueOf(x),Integer.valueOf(y));
        System.out.println(result);
    }
}

