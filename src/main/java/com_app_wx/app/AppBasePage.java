package com_app_wx.app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/11/19 23:25
 * @Description:基础父类
 */
public class AppBasePage {
    //appnium驱动
    public AppiumDriver driver;
    public WebDriverWait wait; //等待
    public TouchAction touchAction;

    public   WebDriverWait getWait(){   //带入驱动
        return  new WebDriverWait(driver,60,1000);
    }

    public TouchAction getTouchAction(){//构造方法中传入driver参数
        return  new TouchAction(driver);
    }

    //引入驱动
    public AppBasePage( AppiumDriver driver ) {
        this.driver = driver;
        AppiumFieldDecorator appiumFieldDecorator =
                new AppiumFieldDecorator(this.driver, Duration.ofMillis(5000));
        //使用initElements方法构造,第一个参数new AppiumFieldDecorator,第二个参数是当前类
        PageFactory.initElements(appiumFieldDecorator,this);
        //PageFactory.initElements方法，配合页面对象模式，为每个页面创建隐式等待
    }
    // 构造方法
    public AppBasePage() {
    }

    //by方法封装
    public void click(By by){
        driver.findElement(by).click();
    }

    //点击事件封装
    public void click( WebElement element ){
        click(element, false); //不滚动时点击
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
    //滑动寻找元素
    public void scroll( WebElement element ) {
        implicitlyWait(2,TimeUnit.SECONDS);
        int startX = driver.manage().window().getSize().getWidth() / 2; //滑动
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

    //隐式等待
    public void implicitlyWait(long time, TimeUnit timeUnit){
        driver.manage().timeouts().implicitlyWait(time, timeUnit);

    }

    //键盘输入封装
    public void sendkeys(WebElement element,String text){
        if (element.isDisplayed()){
            element.clear();
            element.sendKeys(text);
        }else {
            getWait().until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
        }

    }

}
