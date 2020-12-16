package test_web.wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/
 * @Description 公共方法
 */
public class MainPage extends BasePage {

    //优化变量
   // public  static  ChromeDriver driver=null;

    //项目初始化
    public MainPage() {
        String url="https://work.weixin.qq.com/wework_admin/frame";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().deleteAllCookies();
        //todo 优化为从文件获取


        System.out.println(driver.manage().getCookies());

        driver.get(url);

    }

    public ContactPage toContact(){
        //通过定位符 点击联系人
        driver.findElement(By.cssSelector("#menu_contacts")).click();
        //click(By.cssSelector("#menu_contacts"));
        return  new  ContactPage(driver);
    }

}
