package com_app_snowball;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/11/28 22:25
 * @Description:  未优化前
 */
public class SampleTest {

    public  static  AndroidDriver driver;
    private  static MainPage mainPage;
    private static  WebDriverWait wait;
    public SampleTest() {

    }

    @BeforeAll
    public static  void setup() throws MalformedURLException {
        mainPage = new MainPage();
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
    }

    @Test
    public void sampleTest() {
        MobileElement el4 = (MobileElement) driver.findElementById("com.xueqiu.android:id/home_search");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.xueqiu.android:id/search_input_text");
        el5.sendKeys("alibaba");
        MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]");
        el6.click();
    }
    @Test
    @DisplayName("测试名称：滑动测试")
    public  void  swipeTest() throws InterruptedException {
        try {
            int width = driver.manage().window().getSize().getWidth();
            int height = driver.manage().window().getSize().getHeight();
            Thread.sleep(10000);
            TouchAction action = new TouchAction(driver);
            action.press(PointOption.point((int)(width*0.5),(int)(height*0.8))).
                    waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))) //等待2s
                    .moveTo(PointOption.point((int)(width*0.5),(int)(height*0.2))).release().perform(); //按下触屏执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("测试名称：xpath字节测试")
    public void xpathTest() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("阿里巴巴");
        //点击港股阿里巴巴
        driver.findElement(By.xpath("//*[@text='BABA']")).click();
        String text = driver.findElement(By.xpath
                ("//*[@text='09988']/../../..//*[@resource-id='com.xueqiu.android:id/current_price']")).getText();
        System.out.println(text);
    }

    @Test
    @DisplayName("测试名称：UIautomation定位")
    public void UIautomationSelect(){
        AndroidDriver<MobileElement>  driver=(AndroidDriver<MobileElement>)this.driver;
        //通过resourceId 定位
  //      driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.xueqiu.android:id/tab_name\").text(\"交易\")").click();
        //通过classname定位
 //       driver.findElementByAndroidUIAutomator("new UiSelector()" +
  //              ".className(\"android.widget.TextView\").text(\"行情\")").click();
        //通过父子关系定位
        driver.findElementByAndroidUIAutomator("new UiSelector()." +
                "resourceId(\"com.xueqiu.android:id/scroll_view\").childSelector(text(\"热门\")").click();
        //通过兄弟节点定位
        driver.findElementByAndroidUIAutomator("new UiSelector()." +
                "resourceId(\"com.xueqiu.android:id/tab_name\").fromParent(text(\"我的\")").click();

    }

    @Test
    @DisplayName("测试名称：滑动查找")
    public  void scrollFind() throws InterruptedException {
        AndroidDriver<MobileElement> driver=(AndroidDriver<MobileElement>)this.driver;
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator
          ("new UiSelector(new UiSelector().scorllable(true).instance(0)).scorllIntoView(new UiSelector().text(\"雪球\").instance(0))");

    }

   /* @Test
    @DisplayName("测试名称：隐式等待")
    public  void waityinshi() throws InterruptedException {
        wait=new WebDriverWait(driver,10,1000);
        //隐式等待 点击搜索后等待10s
        driver.findElement(By.id("com.xueqiu.amdroid:id/home_search")).click();
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("阿里巴巴");
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text=BABA]")));
        System.out.println(element.getAttribute("enable"));
        element.click();

     }*/


    @Test
    @DisplayName("junt断言")
    public void test_with_junit_assert() {
        int expected = 51;
        int actual = 51;

        assertEquals(" 失败-参数不一致", expected, actual);
    }

    @Test
    @DisplayName("hamcrest断言")
    public void test_with_hamcrest_assertThat() {
        int expected = 51;
        int actual = 51;

        assertThat("失败-参数不一致!", actual, equalTo(expected));
    }


    @Test
    @DisplayName("hamcrest断言")
    public void test_with_hamcrestprice() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("阿里巴巴");
        //点击港股
        driver.findElement(By.xpath("//*[@text='BABA']")).click();
        driver.findElement(By.xpath("//*[@text='股票']")).click();
        Thread.sleep(3000 );
        double realPrice = Double.parseDouble(driver.findElement(
                By.xpath("//*[@text='09988']/../../..//*[@resource-id='com.xueqiu.android:id/current_price']")).getText());
        //hamcrest 断言
        assertThat("股票价格比对",realPrice,greaterThan(500d));
    }

    @ParameterizedTest
    @MethodSource("byNameGetPrice")
    public void searchByParam(String name,String code ,double price)  //声明参数
            throws InterruptedException {
        //Thread.sleep(10000);
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("阿里巴巴");
        //点击港股阿里巴巴
        driver.findElement(By.xpath("//*[@text='BABA']")).click();
        String text = driver.findElement(By.xpath
                ("//*[@text='09988']/../../..//*[@resource-id='com.xueqiu.android:id/current_price']")).getText();
        System.out.println(text);
    }



    // 参数化
    private  static Stream<Arguments> byNameGetPrice(){
        return Stream.of(Arguments.of("alibab","",220d),
                Arguments.of("google","",220d),
                Arguments.of("baidu","",180d)
                ); }








    }






