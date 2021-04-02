package com.zz.app.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhangcheng
 * @Description: 所有 page父类
 * @Date: 2021/3/15/015 14:58
 * @Version: 1.0
 */
public class zzBasePage {

    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;
    //点击驱动
    public TouchAction touchAction;

    public zzBasePage() {
    }
    //带参构造方法
    public zzBasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        wait= new WebDriverWait(driver, 10,1000);
    }
    // 关闭驱动退出 封装
    public void quit(){
        driver.quit();
    }
    //定位负责
    public MobileElement find(By by) {
        return driver.findElement(by);
    }


    public TouchAction getTouchAction(){
        return new TouchAction(driver);
    }
    public WebDriverWait getWait(){
        return new WebDriverWait(driver, 60, 1000);
    }

    //点击动作
    public void click(WebElement element){
        click(element, false);
    }
    public void click(WebElement element, boolean scroll){
        if (scroll){
            scroll(element);
        }
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 滑动动作
    public void scroll(WebElement element){
        implicitlyWait(1, TimeUnit.SECONDS);
        int startX = driver.manage().window().getSize().getWidth() / 2;
        int startY = driver.manage().window().getSize().getHeight() / 2;
        long startTime = System.currentTimeMillis();
        while (true){
            if (!element.isDisplayed()){
                getTouchAction().moveTo(PointOption.point(startX, startY - 50)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)));
                long endTime = System.currentTimeMillis();
                if ((endTime - startTime) > 60*1000){
                    break;
                }
            }else {
                break;
            }
        }
        implicitlyWait(5, TimeUnit.SECONDS);
    }
    private void implicitlyWait(long time, TimeUnit seconds) {
        driver.manage().timeouts().implicitlyWait(time, seconds);
    }

    //输入动作
    public void inputText(WebElement element, String text){
        if (element.isDisplayed()){
            element.clear();
            element.sendKeys(text);
        }else {
            getWait().until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
        }
    }

}
