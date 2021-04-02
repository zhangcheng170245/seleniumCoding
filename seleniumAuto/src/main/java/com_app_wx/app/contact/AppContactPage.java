package com_app_wx.app.contact;

import com_app_wx.app.AppBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
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
    private By menu = By.id("i6i"); //进入通讯录管理
    private By serchButton = By.id("i6n");
    // 添加子部门
    private By addDepart = By.xpath("//*[@text='添加子部门']");
    //编辑
    private By editText = By.className("android.widget.EditText");
    // 搜索内容的值
    private By departName = By.xpath("//android.view.ViewGroup//android.widget.TextView");
    //关闭
    private By closeButton = By.xpath("//*[contains(@resource-id, 'gpf') or contains(@resource-id, 'i6d')]");
    private By confirm = By.id("i6k"); //确定保存
    private By confirmodify = By.id("blx"); //确定修改
    private By back = By.id("i63"); //后退
    private By quit = By.id("i6d"); //退出

    public AppContactPage(AppiumDriver driver) {
        super(driver);
    }


    /**
     * 添加方法
     *
     * @param name 部门名称
     */
    public AppContactPage addDepart(String name) {
        driver.findElement(menu).click();
        driver.findElement(addDepart).click();
        driver.findElement(editText).sendKeys(name);
        driver.findElement(By.xpath("//*[@text='确定']")).click();
        driver.findElement(closeButton).click();

        return this;
    }

    /**
     * 搜索
     *
     * @param keyword
     * @return
     */
    public AppContactPage search(String keyword) {
        driver.findElement(serchButton).click();
        // 输入新建的部门名称
        driver.findElement(editText).sendKeys(keyword);
        return this;
    }

    /**
     * 更新部门
     *
     * @param keyword
     * @return
     */
    public AppContactPage update(String keyword, String newDepartName) throws InterruptedException {
        click(menu);
        //   driver.findElement(menu).click();
        //点击输入的部门的编辑按钮
        driver.findElement(By.xpath("//*[@text='" + keyword + "']")).click();
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
     * @return 获取名称
     */
    public String getName() {
        StringBuilder contents = new StringBuilder();
        driver.findElements(departName).forEach(element -> {
            contents.append(((WebElement) element).getText());
        });

        return driver.findElement(departName).getText();

    }

    public void clearDepart(String name) throws InterruptedException {
        click(By.xpath("//*[@text='通讯录']")); //点击通讯录
        click(menu); //点击通讯录管理
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@text='" + name + "']")).click();
        click(By.id("gg5"));//d点击更多管理
        Thread.sleep(3000);
        click(By.id("egd"));//点击删除
        Thread.sleep(3000);
        click(confirmodify); //点击确定
        Thread.sleep(3000);
        System.out.println("删除部门成功");

    }


    //=============成员添加=====================
    @AndroidFindBy(id = "com.tencent.wework:id/i6i")
    private WebElement clickMenu;
    @AndroidFindBy(xpath = "//*[@text=\"添加成员\"]")
    private WebElement addMem;
    @AndroidFindBy(xpath = "//*[@text=\"手动输入添加\"]")
    private WebElement addBtn;
    @AndroidFindBy(xpath = "//*[@text=\"姓名　\"]/..//*[@resource-id=\"com.tencent.wework:id/b4t\"]")
    private WebElement name;
    @AndroidFindBy(id = "com.tencent.wework:id/fow")
    private WebElement phone;
    @AndroidFindBy(uiAutomator = "resourceId(\"com.tencent.wework:id/b5m\").text(\"设置部门\")")
    private WebElement setDepartBtn; //设置部门
    @AndroidFindBy(xpath = "//*[@text=\"面向对象\"]/../../..//*[@resource-id=\"com.tencent.wework:id/gsi\"]")
    private WebElement childDepart;
    @AndroidFindBy(id = "com.tencent.wework:id/gsh")
    private WebElement confirmBtn;
    @AndroidFindBy(id = "com.tencent.wework:id/i6k")
    private WebElement saveBtn;
    @AndroidFindBy(id = "com.tencent.wework:id/i63")
    private WebElement backBtn;
    //=============成员添加=====================
    @AndroidFindBy(xpath = "//*[@class='android.widget.Toast']")
    private WebElement toast;    //弹窗信息

    /**
     * 添加成员
     *
     * @param username  用户名
     * @param userPhone 手机号
     * @return ContactPage
     */
    public AppContactPage addMember(String username, String userPhone) throws InterruptedException {
        click(clickMenu);
        Thread.sleep(3000);
        click(addMem); // 添加成员
        Thread.sleep(3000);
        click(addBtn); //添加部门
        sendkeys(name, username); //输入
        sendkeys(phone, userPhone);
        click(setDepartBtn); //设置部门
        click(childDepart);
        click(confirmBtn);
        click(saveBtn);
        return this;
    }

    //toast
    public String getToast() {
        return toast.getText();

    }
}

