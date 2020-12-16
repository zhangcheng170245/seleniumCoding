package testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/8/17 08:01
 * @Description:
 */
public class AliceTest {

    public static WebDriver webDriver;
    public static WebDriverWait wait;

    @BeforeAll
    public  static  void initData(){
        webDriver=  new ChromeDriver();
        //隐式等待
        //webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //显shi等待;
        wait=new WebDriverWait(webDriver,5);




    }

    @Test
    public void login(){
        webDriver.get("https://home.testing-studio.com/");
        webDriver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();

        //login-account-name
        webDriver.findElement(By.id("login-account-name")).clear();
        webDriver.findElement(By.id("login-account-name")).sendKeys("170902823@qq.com");

        webDriver.findElement(By.id("login-account-password")).clear();
        webDriver.findElement(By.id("login-account-password")).sendKeys("z3c231935");

        webDriver.findElement(By.id("login-button")).click();

    }

    @Test
    public void timeSleepTest() throws InterruptedException {

        webDriver.get("https://home.testing-studio.com/");

        //Thread.sleep(5000);
        webDriver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
      //  wait.until();
    }
    @Test
    public void WaitTest() throws InterruptedException {

        webDriver.get("https://home.testing-studio.com/");
        
       // webDriver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        //
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'登录')]")));

        webElement.click();



    }

    @AfterAll
    public static  void shutdown(){
        webDriver.quit();
    }
}
