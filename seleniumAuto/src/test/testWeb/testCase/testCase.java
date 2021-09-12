package testCase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.FakerUtils;

/**
 * @ProjectName: coding
 * @Package: PACKAGE_NAME
 * @ClassName: testCase.testCase
 * @Author: 还是那个橙子
 * @Description: 网页自动化测试用例
 * @Date: 2021/9/12 12:40
 * @Version: 1.0
 */
public class testCase {
    public static WebDriver driver;
    public static WebDriverWait webDriverWait;

    @BeforeAll
    static void initData(){
        //加载驱动
        driver=new ChromeDriver();

        // 设置全局隐式等待 5S
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriverWait= new WebDriverWait(driver,5L);
    }

    @Test
    void Login(){
        //读取测试链接
        driver.get("https://home.testing-studio.com/");
        //获取登录按钮
        driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        driver.manage().window().maximize();
        //清理记住的原账号与密码
        driver.findElement(By.id("login-account-name")).clear();
        driver.findElement(By.id("login-account-name")).sendKeys("*");

        driver.findElement(By.id("login-account-password")).clear();
        driver.findElement(By.id("login-account-password")).sendKeys("*");
        driver.findElement(By.id("login-button")).click();
        // 截图
        FakerUtils.snapshot((TakesScreenshot)driver,"截图"+FakerUtils.getTimeStamp()+".jpg");
    }

    @Test
    void  waittest(){
        //读取测试链接
        driver.get("https://home.testing-studio.com/");
        //获取登录按钮
        driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        driver.manage().window().maximize();
        //匿名内部类的写法
  /*      webDriverWait.until(new Function<WebDriver, Object>() {
            @Override
            public Object apply(WebDriver webDriver) {
                return driver.findElement(By.id("foo"));
            }
        });*/


    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }

}
