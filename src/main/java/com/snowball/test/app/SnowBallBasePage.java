package com.snowball.test.app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/11/22 23:21
 * @Description:
 */
public class SnowBallBasePage {
    //appnium驱动
    public static AppiumDriver driver;

    private WebDriverWait wait;


    @BeforeAll
    static void ininEnv() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("udid", "a160c6af7d23");
        capabilities.setCapability("deviceName", "Redmi_6A");
        capabilities.setCapability("appPackage", "com.xueqiu.android");
        //设置最先加载的activiity写错，通过启动手机上的APP，
        // 执行以下命令：adb shell dumpsys window | findstr mCurrentFocus（获取到的activity不是最先加载的）
        capabilities.setCapability("appActivity", ".main.view.MainActivity");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("dontStopAppOnReset", "true");

        //链接appniumserver地址
        // driver = new AppiumDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        // 隐式等待
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    // X
}
