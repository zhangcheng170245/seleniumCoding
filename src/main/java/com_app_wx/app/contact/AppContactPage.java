package com_app_wx.app.contact;

import com_app_wx.app.AppBasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/11/24 21:37
 * @Description: 联系人
 */
public class AppContactPage extends AppBasePage {
    //参数封装
    //搜素
    private By menu=By.id("i6i");
    private By serchButton=By.id("i6n");
    // 添加子部门
    private By addDepart=By.xpath("//*[@text='添加子部门']");
    //编辑
    private By editText=By.className("android.widget.EditText");
    // 搜索内容的值
    private By departName=By.xpath("//android.view.ViewGroup//android.widget.TextView");
    //关闭
    private By closeButton=By.xpath("//*[contains(@resource-id, 'gpf') or contains(@resource-id, 'i6d')]");


    public AppContactPage( AppiumDriver driver ) {
        super(driver);
    }

    /**
     * 添加方法
     * @param name 部门名称
     */
    public AppContactPage addDepart(String name){
        driver.findElement(menu).click();
        driver.findElement(addDepart).click();
        driver.findElement(editText).sendKeys(name);
        driver.findElement(By.xpath("//*[@text='确定']")).click();
        driver.findElement(closeButton).click();

        return this;
    }

    /**
     * 搜索
     * @param keyword
     * @return
     */
    public AppContactPage search(String keyword){
        driver.findElement(serchButton).click();
        // 输入新建的部门名称
        driver.findElement(editText).sendKeys(keyword);
        return this;
    }

    /**
     *
     * @return 获取名称
     */
    public String getName( ){
        StringBuilder contents=new StringBuilder();
        driver.findElements(departName).forEach(element->{
            contents.append(((WebElement)element).getText());
        });

        return  driver.findElement(departName).getText();

    }

}

