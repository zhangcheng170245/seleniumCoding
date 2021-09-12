package test;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import util.FakerUtils;

import java.io.File;
import java.io.IOException;


/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/8/16 23:07
 * @Description:seleium demo
 */
public class startSelenum  {


    @Test
    public void test1() throws IOException {
        ChromeDriver driver = new ChromeDriver();
        System. setProperty("webdriver.chrome.driver", "path");
        //设置全屏
        driver.manage().window().maximize();
        driver.get("https://home.testing-studio.com/");
        //d.findElement(By.cssSelector(". d-button-abl").cick();
        driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        snapshot((TakesScreenshot)driver, "截图"+FakerUtils.getTimeStamp()+".jpg");
        // 获取截屏方法

    }
    // 截屏方法
    public static void snapshot(TakesScreenshot drivername, String filename) {
        String currentPath = System.getProperty("user.dir"); //get current work folder
        System.out.println(currentPath);
        File scrFile = drivername.getScreenshotAs(OutputType.FILE);
        try {
            System.out.println("save snapshot path is:"+currentPath+"/"+filename);
            FileUtils.copyFile(scrFile, new File(currentPath+"\\"+filename));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Can't save screenshot");
            e.printStackTrace();
        } finally {
            System.out.println("screen shot finished");
        }
    }

}
