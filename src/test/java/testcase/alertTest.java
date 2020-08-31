package testcase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/8/21 08:09
 * @Description:窗口切换
 */
public class alertTest {

    public static WebDriver webDriver;

    public  static Actions actions;

    @BeforeAll
    public static void initData() {
        webDriver = new ChromeDriver();
        actions= new Actions(webDriver);
        //设置3秒等待
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test() //点击测试
    public void win() throws InterruptedException {
        //跳转测试网页
        webDriver.get("https://www.runoob.com/try/try.php?filename=jqueryui-example-droppable");
        webDriver.switchTo().frame("iframeResult");
        actions.dragAndDrop(webDriver.findElement(By.id("draggable")),
                webDriver.findElement(By.id("droppable"))).perform();
        Thread.sleep(5000);
        //同意
        webDriver.switchTo().alert().accept();
        //切回frame
        webDriver.switchTo().parentFrame();

        webDriver.findElement(By.id("submitBTN")).getText();

        System.out.println(webDriver.findElement(By.id("submitBTN")).getText());


    }
}

