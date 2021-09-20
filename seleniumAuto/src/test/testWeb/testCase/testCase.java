package testCase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
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
public class testCase  {
    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    public static WebElement element;

    @BeforeAll
    static void initData(){
        //加载驱动
        driver=new ChromeDriver();
        // 设置全局隐式等待 5S
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriverWait= new WebDriverWait(driver,5L);
    }

    @Test
    void Login() throws InterruptedException {
        //读取测试链接
        driver.get("https://home.testing-studio.com/");
        //获取登录按钮
        driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        driver.manage().window().maximize();
        //清理记住的原账号与密码
        driver.findElement(By.id("login-account-name")).clear();
        driver.findElement(By.id("login-account-name")).sendKeys("*");

        driver.findElement(By.id("login-account-password")).clear();
        //获取登录的高亮元素
        element = driver.findElement(By.id("login-account-password"));
        //高亮
        highLight(element);
        Thread.sleep ( 2000 );
        driver.findElement(By.id("login-account-password")).sendKeys("*");
        JavascriptExecutor js= (JavascriptExecutor) driver;
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

    // 封装展示高亮的方法
    public  static void highLight(WebElement element){
        //创建一个JavascriptExecutor对象
        JavascriptExecutor js= (JavascriptExecutor) driver;
        // 设置组件高亮
        //js.executeAsyncScript("arguments[0].style.border=\"5px solid red\"", webElement);
        js.executeAsyncScript("element = arguments[0];" +
                "original_style = element.getAttribute('style');" +
                "element.setAttribute('style', original_style + \";" +
                "background: yellow; border: 2px solid red;\");" +
                "setTimeout(function(){element.setAttribute('style', original_style);}, 1000);", element);

    }


}
