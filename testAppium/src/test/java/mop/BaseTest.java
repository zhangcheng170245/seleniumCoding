package mop;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/14/014 16:10
 * @Version: 1.0
 */
public class BaseTest {
    // 驱动
    private static AppiumDriver driver;
    public WebDriverWait wait;


    @BeforeAll
    public static  void setUp(){
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "android");
            desiredCapabilities.setCapability("deviceName", "Redmi_6A");
            desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
            desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
            desiredCapabilities.setCapability("noReset", "true");
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
    void swipe() {
 //       driver.findElement(By.xpath("先浏览看看")).click()；
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("阿里巴巴");
        driver.findElement(By.xpath("//*[@text='BABA']")).click();
        String price2 = "//*[@text='09988']/../../..//*[@resource-id='com.xueqiu.android:id/current_price']";
        System.out.println(driver.findElement(By.xpath(price2)).getText());

    }

    @Test
    void helloSnowBallTest() {

        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("阿里巴巴");
        driver.findElement(By.xpath("//*[@text='BABA']")).click();
        String price2 = "//*[@text='09988']/../../..//*[@resource-id='com.xueqiu.android:id/current_price']";
        System.out.println(driver.findElement(By.xpath(price2)).getText());

    }


    @Test
    void searchTest(){
        WebElement home_search = driver.findElement(By.id("com.xueqiu.android:id/home_search"));

        if(home_search.getAttribute("enabled").equals("true")){
            System.out.println(home_search.getLocation().toString());
            home_search.click();

            WebElement search_input_text = driver.findElement(By.id("com.xueqiu.android:id/search_input_text"));

            if(search_input_text.getAttribute("displayed").equals("true")){
                search_input_text.sendKeys("alibaba");
                System.out.println("搜索成功");

            } else{
                System.out.println("搜索失败");
            }
        }
    }

    @Test
    void setWaitfun() {
        wait=new WebDriverWait(driver,10,1000);

        driver.findElement(By.id("com.xueqiu.android:id/home_search"));
        driver.findElement( By.id("com.xueqiu.android:id/search_input_text"));


    }

}
