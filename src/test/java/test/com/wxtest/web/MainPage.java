package test.com.wxtest.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage{

    void needLogin() throws IOException, InterruptedException {
        //扫码登录
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        //sleep 20
        Thread.sleep(15000);
        // 获取cookie
        Set<Cookie> cookies = driver.manage().getCookies();
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.writeValue(new File("cookies.yaml"),cookies);
        System.exit(0);
    }

    void  beforeAll() throws IOException, InterruptedException {
        //获取 yaml文件
        File file = new File("cookies.yaml");
        if (file.exists()){
             driver = new ChromeDriver();
             driver.get("https://work.weixin.qq.com/wework_admin/frame");
             ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
             TypeReference typeReference = new TypeReference<List<HashMap<String, Object>>>() {};
             List<HashMap<String, Object>>  cookies = objectMapper.readValue(file, typeReference);
            System.out.println(cookies);
            System.out.println("读取cookie成功");
             cookies.forEach(cookieMap ->{
                 driver.manage().addCookie(new Cookie(cookieMap.get("name").toString()
                         ,cookieMap.get("value").toString()));
             });
            driver.navigate().refresh();
        }else {
            needLogin();
        }
    }

    public MainPage() throws IOException, InterruptedException {
        this.beforeAll();
    }

    public ContactPage contactPage(){
        //po原则4 跳转或者进入新页面使用返回新的po来模拟
        click(By.id("menu_contacts"));
        return  new ContactPage(driver);
    }

    public MemberPage MemberPage(){
        click(By.id("menu_contacts"));
        //po原则4 跳转或者进入新页面使用返回新的po来模拟
        return new MemberPage(driver);
    }

}
