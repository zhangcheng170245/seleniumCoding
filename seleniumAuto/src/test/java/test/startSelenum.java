package test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;


/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/8/16 23:07
 * @Description:
 */
public class startSelenum {


    @Test
    public void test1(){
        ChromeDriver driver = new ChromeDriver();
        System. setProperty("webdriver.chrome.driver", "path");
        driver.get("https://home.testing-studio.com/");
//d.findElement(By.cssSelector(". d-button-abl").cick();
        driver.findElement(By.xpath("//span[contains(text(),'Sign Up')]")).click();

    }
}
