package com.retry.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/14/014 21:59
 * @Version: 1.0
 */
public class Search {
    // 驱动
    private static AppiumDriver driver;
    // public static WebDriverWait wait;

    @BeforeAll
    public static  void setUp(){
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "android");
            desiredCapabilities.setCapability("deviceName", "Redmi_6A");
            desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
            desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
            //desiredCapabilities.setCapability("noReset", "true");
            desiredCapabilities.setCapability("udid", "a160c6af7d23");
            //链接appniumserver地址
            driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
            // 隐式等待
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }

    }

    @Test
    public void fun() {


    }
}
