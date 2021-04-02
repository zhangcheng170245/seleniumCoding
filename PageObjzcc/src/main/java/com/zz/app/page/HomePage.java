package com.zz.app.page;

import com.zz.app.core.zzAppFactory;
import com.zz.app.core.zzBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.time.Duration;

/**
 * @Author: zhangcheng
 * @Description: app主页功能
 * @Date: 2021/3/15/015 16:26
 * @Version: 1.0
 */
public class HomePage extends zzBasePage {
    //实现构造方法
    public HomePage() {
        initDriver();
    }

    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    // 初始化驱动
    public void initDriver() {
        //从驱动工厂获取驱动
        try {
            driver = zzAppFactory.getDriver();
            AppiumFieldDecorator decorator = new AppiumFieldDecorator(this.driver, Duration.ofMillis(6000));
            PageFactory.initElements(decorator, this);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //点击首页的目录
    @AndroidFindBy(uiAutomator = "resourceId(\\\"com.tencent.wework:id/egd\\\").text(\\\"通讯录\\\")")
    private WebElement clickContact;

    //点击通讯录进入
    public ContactPage contactPage() {
        click(clickContact);
        return new ContactPage(driver); // 进去通讯录
    }

}
