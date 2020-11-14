package test.WxTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/11/12 12:29
 * @Description:企业微信自动化
 */

public class WechatWeb {

    private WebDriver driver;

    @Test
    public void before(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        //利用chromedriver控制chrome
        driver = new ChromeDriver();
        driver.get("https://work.weixin.qq.com/wework_admin/loginpage_wx?from=myhome");
        //延时
        try {
            Thread.sleep(15000);
            // 获取cookie
            Set<Cookie> cookies = driver.manage().getCookies();
            //写入到yaml文件  序列号到文件
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            objectMapper.writeValue(new File("cookies.yaml"),cookies);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void logined() throws IOException, InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        //反序列化 引用
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        TypeReference typeReference = new TypeReference<List<HashMap<String, Object>>>() {
        };
        //读取cookie
        List<HashMap<String, Object>> cookies = objectMapper.readValue(new File("cookies.yaml"), typeReference);
        //   System.out.println(cookies);
        //登录信息中添加cookies
        cookies.forEach(cookieMAP -> {
            driver.manage().addCookie(new Cookie(
                    cookieMAP.get("name").toString(), cookieMAP.get("value").toString()));
        });
        //refresh
        driver.navigate().refresh();
        driver.manage().window().maximize();
        //定位到通讯录按钮
        //通过定位符 点击联系人
        driver.findElement(By.cssSelector("#menu_contacts")).click();
        //点击添加联系人
        driver.findElement(By.xpath("//span[contains(text(),'添加成员')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("username")).sendKeys("张2三");
        Thread.sleep(1000);
        driver.findElement(By.name("acctid")).sendKeys("1111111");
        Thread.sleep(1000);
        driver.findElement(By.id("memberAdd_phone")).sendKeys("13428283251");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='qui_btn ww_btn js_btn_save']")).click();
        Thread.sleep(5000);

        driver.quit();

    }
}
