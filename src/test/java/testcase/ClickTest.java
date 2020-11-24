package testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.util.concurrent.TimeUnit;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/8/20 21:39
 * @Description:
 */
public class ClickTest {

    public static WebDriver webDriver;

    public  static  Actions actions;

    @BeforeAll
    public static void initData() {
        webDriver = new ChromeDriver();
        actions= new Actions(webDriver);
        //设置3秒等待
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    //@Ignore
    @Test() //点击测试
    public void click() throws InterruptedException {
        //跳转测试网页
        webDriver.get("http://sahitest.com/demo/clicks.htm");
        //单击
        actions.click(webDriver.findElement(By.xpath("//input[@value='click me']")));  //获取input框单击的属性
      //  actions.perform();
        actions.doubleClick(webDriver.findElement(By.xpath("//input[@value='dbl click me']"))); // 双击
    //    actions.perform();
        actions.contextClick(webDriver.findElement(By.xpath("//input[@value='right click me']"))); //右键
        actions.perform();
        Thread.sleep(3000);
    }


    @Test
    public  void moveTest() throws InterruptedException {
        //跳转测试网页
        webDriver.get("https://www.baidu.com/");
        // 通过id获取位置
        actions.moveToElement(webDriver.findElement(By.id("s-usersetting-top")));
        actions.perform();
        Thread.sleep(3000);
    }


    // 拖拽测试
    @Test
    public  void dragTest() throws InterruptedException {
        //跳转测试网页
        webDriver.get("http://sahitest.com/demo/dragDropMooTools.htm");
        // 通过id获取位置
        actions.dragAndDrop(webDriver.findElement(By.id("dragger")),
                webDriver.findElement(By.xpath("//*[@class='item'][last()]"))).perform();
        Thread.sleep(3000);
    }


    @Test
    public  void keytest() throws InterruptedException {
        //跳转测试网页
        webDriver.get("http://sahitest.com/demo/label.htm");
        // 通过xpath 上下文
        webDriver.findElements(By.xpath("//input[@type='textbox']")).get(0).sendKeys("ceshi");
        //全选
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        //crtl+c 复制
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        // ctrl+v
        actions.keyDown(webDriver.findElements(By.xpath("//input[@type='textbox']")).get(0),
                Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        Thread.sleep(3000);
    }



    @Test
    public  void socrll()  {

        try {

        //跳转测试网页
        webDriver.get("https://www.baidu.com/");
        // 通过xpath 上下文
        webDriver.findElement(By.id("kw")).sendKeys("今日头条");

        TouchActions actions = new TouchActions(webDriver);

        actions.click(webDriver.findElement(By.id("su"))); // 点击百度一下

        JavascriptExecutor js= (JavascriptExecutor) webDriver;  // 驱动强转为js驱动
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");  //滑动到底部
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//a[@class='n']")).click();
        Thread.sleep(3000);
    }catch (Exception e){
            e.printStackTrace();
        }
    }









    @AfterAll
    public static void  teardowen(){
        webDriver.quit();
    }
}
