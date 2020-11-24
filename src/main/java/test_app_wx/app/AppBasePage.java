package test_app_wx.app;

import io.appium.java_client.AppiumDriver;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/11/19 23:25
 * @Description:基础父类
 */
public class AppBasePage {
    //appnium驱动
    public AppiumDriver driver;

    //引入驱动
    public AppBasePage( AppiumDriver driver ) {
        this.driver = driver;
    }

    // 构造方法
    public AppBasePage() {

    }

}
