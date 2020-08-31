package testcase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/8/24 08:30
 * @Description:
 */
public class UploadTest {
    public static WebDriver webDriver;

    @BeforeAll
    public static void initData() {
        webDriver = new ChromeDriver();
        //设置3秒等待
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void testUpload() throws InterruptedException {
        webDriver.get("https://www.baidu.com/");
        webDriver.manage().window().maximize();
        //查找
        webDriver.findElement(By.xpath("//span[@class='soutu-btn']")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("//input[@class='upload-pic']")).sendKeys("F://壁纸//05.jpg");
        Thread.sleep(5000);
    }
}
