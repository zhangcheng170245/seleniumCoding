package com.zz.app.core;

import com.zz.app.config.config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: zhangcheng
 * @Description:  生成AppiumDriver的工厂类
 * @Date: 2021/3/15/015 15:34
 * @Version: 1.0
 */
public class zzAppFactory {
    public static AppiumDriver<MobileElement> getDriver() throws MalformedURLException {
        AppiumDriver driver = new AppiumDriver<>(new URL(config.APP_SERVER),
                new zzAppset().initAndroid());
        return driver;
    }



}
