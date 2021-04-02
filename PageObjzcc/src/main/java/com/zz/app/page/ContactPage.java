package com.zz.app.page;

import com.zz.app.core.zzBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * @Author: zhangcheng
 * @Description: 联系人
 * @Date: 2021/3/15/015 16:41
 * @Version: 1.0
 */
public class ContactPage  extends zzBasePage {
    public ContactPage(AppiumDriver<MobileElement> driver) {
    }
    // 封装操作登录
    //======================================添加成员============================================
    @AndroidFindBy(xpath = "//*[@text=\"添加成员\"]")
    private WebElement addMemberBtn;
    @AndroidFindBy(xpath = "//*[@text=\"手动输入添加\"]")
    private WebElement manuallyAddBtn;
    @AndroidFindBy(xpath = "//*[@text=\"姓名　\"]/..//*[@resource-id=\"com.tencent.wework:id/b4t\"]")
    private WebElement name;
    @AndroidFindBy(id = "com.tencent.wework:id/fow")
    private WebElement phone;
    @AndroidFindBy(uiAutomator = "resourceId(\"com.tencent.wework:id/b5m\").text(\"设置部门\")")
    private WebElement setDepartBtn;
    @AndroidFindBy(xpath = "//*[@text=\"定向4期2\"]/../../..//*[@resource-id=\"com.tencent.wework:id/gsi\"]")
    private WebElement childDepart;
    @AndroidFindBy(id = "com.tencent.wework:id/gsh")
    private WebElement confirmBtn;
    @AndroidFindBy(id = "com.tencent.wework:id/i6k")
    private WebElement saveBtn;
    @AndroidFindBy(id = "com.tencent.wework:id/i63")
    private WebElement backBtn;
    //======================================添加成员============================================
    // ======================================搜索成员并编辑============================================
    @AndroidFindBy(id = "com.tencent.wework:id/i6n")
    private WebElement searchBtn;
    @AndroidFindBy(id = "com.tencent.wework:id/gpg")
    private WebElement searchInput;
    @AndroidFindBy(id = "com.tencent.wework:id/dns")
    private WebElement searchResult;
    @AndroidFindBy(id = "com.tencent.wework:id/i6d")
    private WebElement selectBtn;
    @AndroidFindBy(id = "com.tencent.wework:id/b_x")
    private WebElement editBtn;
    @AndroidFindBy(id = "com.tencent.wework:id/elq")
    private WebElement genderSelect;
    @AndroidFindBy(xpath = "//*[@text=\"男\"]")
    private WebElement manSelect;
    @AndroidFindBy(xpath = "//*[@text=\"删除成员\"]")
    private WebElement deleteMemberBtn;
    @AndroidFindBy(id = "com.tencent.wework:id/blx")
    private WebElement confirmDeleteBtn;
    @AndroidFindBy(xpath = "//*[@class='android.widget.Toast']")
    private WebElement toast;



    /**
     * 添加成员
     * @param username	用户名
     * @param userPhone		手机号
     * @return	ContactPage
     */
    public ContactPage addMember(String username, String userPhone){
        click(addMemberBtn);
        click(manuallyAddBtn);
        inputText(name, username);
        inputText(phone, userPhone);
        click(setDepartBtn);
        click(childDepart);
        click(confirmBtn);
        click(saveBtn);
        return this;
    }
    //搜索
    public ContactPage searchEditMember(String searchName){
        click(addMemberBtn);
        inputText(searchInput, searchName);
        click(searchResult);
        click(selectBtn);
        click(editBtn);
        click(genderSelect);
        click(manSelect);
        click(saveBtn);
        return this;
    }
    //删除
    public ContactPage deleteMember(String searchName){
        click(searchBtn);
        inputText(searchInput, searchName);
        click(searchResult);
        click(selectBtn);
        click(editBtn);
        click(deleteMemberBtn);
        click(confirmDeleteBtn);
        return this;
    }

    public String getToast(){
        return toast.getText();
    }
}
