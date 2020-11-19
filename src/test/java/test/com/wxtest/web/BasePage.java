package test.com.wxtest.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public BasePage(){

    }

    void click(By by){
        driver.findElement(by).click();
    }

    void sendKeys(By by,String content){
        driver.findElement(by).sendKeys(content);
    }


    String getText(By by){
        return driver.findElement(by).getText();
    }


    //等待元素
    void waitElem(By by){
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //下拉框操作
    Select select(WebElement element){
        return new Select(element);
    }

    void clear(By by){
        driver.findElement(by).clear();
    }



}
