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
public class windowTest {

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
        webDriver.get("https://www.baidu.com/");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//*[@id='u1']/a[last()]")).click();
        // 获取百度首页的句柄
        String baiduwin = webDriver.getWindowHandle();
        //获取立即注册
        webDriver.findElement(By.xpath("//a[@class='pass-reglink pass-link']")).click();
        //获取全部的窗口
         webDriver.getWindowHandles();
        for ( String win: webDriver.getWindowHandles()) {
            if (!win.equals(baiduwin)){
                webDriver.switchTo().window(win);
                webDriver.findElement(By.id("TANGRAM__PSP_4__userName")).sendKeys("SADASD");
                webDriver.findElement(By.id("TANGRAM__PSP_4__phone")).sendKeys("13265415754");
                //输入后切换窗口 登录页
                webDriver.switchTo().window(baiduwin);
                //点ji用户名登录
                webDriver.findElement(By.id("TANGRAM__PSP_11__footerULoginBtn")).click();
                webDriver.findElement(By.id("TANGRAM__PSP_11__userName")).sendKeys("sdsa");
                webDriver.findElement(By.id("TANGRAM__PSP_11__password")).sendKeys("sadsadsad");
                Thread.sleep(10000);
            }
        }

    }








}

