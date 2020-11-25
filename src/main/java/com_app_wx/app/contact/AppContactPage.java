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
    private By menu=By.id("i6i"); //进入通讯录管理
    private By serchButton=By.id("i6n");
    // 添加子部门
    private By addDepart=By.xpath("//*[@text='添加子部门']");
    //编辑
    private By editText=By.className("android.widget.EditText");
    // 搜索内容的值
    private By departName=By.xpath("//android.view.ViewGroup//android.widget.TextView");
    //关闭
    private By closeButton=By.xpath("//*[contains(@resource-id, 'gpf') or contains(@resource-id, 'i6d')]");
    private By confirm = By.id("i6k"); //确定保存
    private By confirmodify = By.id("blx"); //确定修改
    private By back = By.id("i63"); //后退
    private By quit = By.id("i6d"); //退出

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
     * 更新部门
     * @param keyword
     * @return
     */
    public AppContactPage update(String keyword,String newDepartName) throws InterruptedException {
        click(menu);
     //   driver.findElement(menu).click();
        //点击输入的部门的编辑按钮
        driver.findElement(By.xpath("//*[@text='"+keyword+"']")).click();
        Thread.sleep(2000);
        //点击更多管理
        driver.findElement(By.id("gg5")).click();
        //点击修改
        driver.findElement(By.id("egd")).click();
        //点击输入框关闭
        driver.findElement(By.id("blm")).click();
        Thread.sleep(3000);
        //再次点击输入新部门
        driver.findElement(By.id("blm")).sendKeys(newDepartName);
        driver.findElement(confirmodify).click();
        System.out.println(" 修改成功");
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

    public void clearDepart(String name) throws InterruptedException {
        click(By.xpath("//*[@text='通讯录']")); //点击通讯录
        click(menu); //点击通讯录管理
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@text='"+name+"']")).click();
        click(By.id("gg5"));//d点击更多管理
        Thread.sleep(3000);
        click(By.id("egd"));//点击删除
        Thread.sleep(3000);
        click(confirmodify); //点击确定
        Thread.sleep(3000);
        System.out.println("删除部门成功");

    }


}

