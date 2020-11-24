package testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/8/20 21:39
 * @Description:
 */
public class JsTest {

    public static WebDriver webDriver;

    public  static  Actions actions;

    @BeforeAll
    public static void initData() {
        webDriver = new ChromeDriver();
        actions= new Actions(webDriver);
        //设置3秒等待
        webDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @Test
        public  void moveTest() throws InterruptedException {
            //跳转测试网页
            webDriver.get("https://www.12306.cn/index/");
            // 通过id获取位置
            JavascriptExecutor jswebDriver =(JavascriptExecutor)webDriver;

            jswebDriver.executeScript("document.getElementById('train_date').value('2020-08-25')");
            System.out.println();
    }

    @AfterAll
    public static void  teardowen(){
        webDriver.quit();
    }
}
