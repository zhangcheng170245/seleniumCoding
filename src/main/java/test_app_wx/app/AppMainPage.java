package test_app_wx.app;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_app_wx.DriverFactory;
import test_app_wx.app.contact.AppContactPage;

import java.net.MalformedURLException;


/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/11/22 13:17
 * @Description: 首页
 */
public class AppMainPage extends  AppBasePage{

    public AppMainPage( AppiumDriver driver ) {
        super(driver);
    }

    public AppMainPage() throws MalformedURLException {


        driver= (AppiumDriver) DriverFactory.getInstance().createDriver();
        System.out.println(driver);
        new WebDriverWait(driver, 120)
                .until(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='通讯录']")));
    }



    public AppContactPage contact(  ){
        //todo 函数待封装
        driver.findElement(By.xpath("//*[@text='通讯录']")).click();
        return new AppContactPage(driver);
    }


}
