/*
package test.pageObj;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

*/
/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/8/27 17:33
 * @Description:y业务层
 *//*

public class TestPageObj {
    //登录
    public static final String URL="https://i.360kan.com/login";
    public static WebDriver webDriver;



    @BeforeAll
    public static void initData() {
        webDriver = new ChromeDriver();
        //设置3秒等待
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get(URL);
        webDriver.manage().window().maximize();
    }


    //登录测试
    @Test
    public void test(){
        loginAction loginAction = new loginAction(webDriver);
        loginAction.login("uname","pwd","输入错误");


    }


    @AfterAll
    public static  void shutdown(){
        webDriver.quit();
    }
}
*/
