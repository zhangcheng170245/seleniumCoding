package com_app_wx.app;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

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
    //输入事件封装
    void sendkeys( By by, String contents){
        driver.findElement(by).sendKeys(contents);
    }

    //by方法封装
    void click(By by){
        driver.findElement(by).click();
    }
}
