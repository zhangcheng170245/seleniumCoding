package test.test_app_wx;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/11/20 11:36
 * @Description:
 */
public class WeWorkClassicTest {

    public static AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

     @BeforeAll
     static  void Env() throws MalformedURLException {
            try {
            DesiredCapabilities caps = new DesiredCapabilities();

            caps.setCapability("platformName", "Android");
           // 不写 默认找第一个设备
            caps.setCapability("udid", "a160c6af7d23");
            caps.setCapability("platformVersion", "9");
            caps.setCapability("deviceName", "Redmi_6A");
            caps.setCapability("appPackage", "com.tencent.wework");
            //设置最先加载的activiity写错，通过启动手机上的APP，
            // 执行以下命令：adb shell dumpsys window | findstr mCurrentFocus（获取到的activity不是最先加载的）
            caps.setCapability("appActivity", ".launch.LaunchSplashActivity");
            caps.setCapability("noReset", "True");
            //链接appniumserver地址
            driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
            System.out.println("安卓驱动链接成功");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //  driver.findElement(MobileBy.id("i6n")).click();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
        }
    }

    //测试搜索
    @Test
    void search(){
        //点击搜索
        driver.findElement(MobileBy.id("i6n")).click();
        //搜索内容
        driver.findElement(MobileBy.id("gpg")).sendKeys("cesgi");

    }

    @Test
    void addMember(){
        //强转为安卓驱动
        AndroidDriver<MobileElement> androidDriver= (AndroidDriver<MobileElement>) this.driver;
        //等待10s
        wait = new WebDriverWait(androidDriver, 10);
        //点击通讯录
        System.out.println("点击通讯录");
        driver.findElement(By.xpath("//*[@text='通讯录']")).click();
        // 点击添加成员
        driver.findElement(By.xpath("//*[@text='添加成员']")).click();
        // 点击手动输入添加
        driver.findElement(By.xpath("//*[@text='手动输入添加']")).click();

        //输入成员信息
        By nameCode = By.id("b4t");
        By emailCode = By.xpath("//*[@resource-id='com.tencent.wework:id/eh_']/descendant::android.widget.EditText");
        By addressCode = By.xpath("//*[@resource-id='com.tencent.wework:id/egn']/descendant::android.widget.TextView");
        driver.findElement(nameCode).sendKeys("Ethan");
        driver.findElement(By.id("fiv")).sendKeys("18611111111");
        driver.findElement(emailCode).sendKeys("123456789@qq.com");
        driver.findElement(addressCode).click();
        driver.findElement(By.id("it")).sendKeys("腾讯大厦");
        driver.findElement(By.xpath("//*[@text='确定']")).click();
        driver.findElement(By.xpath("//*[@text='保存']")).click();


    }
}
