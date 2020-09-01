package test_web.wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/8/31 23:07
 * @Description: 共用方法抽取
 */
public class BasePage {

    RemoteWebDriver driver;
    WebDriverWait wait;

    public BasePage() {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;

    }

    public BasePage( RemoteWebDriver driver ) {
        this.driver = driver;
    }
    // 抽取公用退出
    public void quit(){
        driver.quit();
    }

    //find 方法抽取
    public void click( By by ){
        wait.until(ExpectedConditions.elementToBeClickable(by));
      driver.findElement(by).click();

    }
    //提取sendkeys方法
    public void sendKeys(By by, String content) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(content);
    }



}
