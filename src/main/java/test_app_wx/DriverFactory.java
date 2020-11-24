package test_app_wx;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/11/22 13:27
 * @Description: 驱动工厂
 */
public class DriverFactory {
    private static DriverFactory instance;
    public static DriverFactory getInstance() {
        if(instance==null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public WebDriver createDriver( ) throws MalformedURLException {

             WebDriver driver = null;
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("udid", "a160c6af7d23");
            capabilities.setCapability("deviceName", "Redmi_6A");
            capabilities.setCapability("appPackage", "com.tencent.wework");
            //设置最先加载的activiity写错，通过启动手机上的APP，
            // 执行以下命令：adb shell dumpsys window | findstr mCurrentFocus（获取到的activity不是最先加载的）
            capabilities.setCapability("appActivity", ".launch.LaunchSplashActivity");
            capabilities.setCapability("noReset", "true");
            capabilities.setCapability("dontStopAppOnReset", "true");

            //链接appniumserver地址
           // driver = new AppiumDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

            // 隐式等待
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return driver;

    }
}
