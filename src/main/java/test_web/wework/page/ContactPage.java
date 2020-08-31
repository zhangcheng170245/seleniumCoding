package test_web.wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/8/31 07:51
 * @Description:联系人
 */
public class ContactPage {
    //提取
    By addMember=By.linkText("添加成员");
    By username=By.name("username");
    By delete=By.linkText("删除");
    RemoteWebDriver driver;

    //初始化方法
    public ContactPage( RemoteWebDriver driver ) {
        this.driver=driver;
    }


    public ContactPage addMermber(String username,String acctid ,String mobile){
        //姓名为空 点击新增
        while (driver.findElements(this.username).size()==0){
            driver.findElement(addMember).click();
        }
      
     driver.findElement(this.username).sendKeys(username);
     driver.findElement(By.name("acctid")).sendKeys(acctid);
     driver.findElement(By.name("mobile")).sendKeys(mobile);
        //保存
     driver.findElement(By.cssSelector(".js_btn_save")).click();

        return this;
    }

    // search
    public  ContactPage search (String keyword){
     driver.findElement(By.id("memberSearchInput")).sendKeys(keyword);
        return this;
    }
    public ContactPage delete(){
     driver.findElement(delete).click();
     driver.findElement(By.linkText("确认")).click();
     driver.findElement(By.id("clearMemberSearchInput")).click();
        return this;

    }

    public String getUserName(){
        return driver.findElement(By.cssSelector(".member_display_cover_detail_name")).getText();
    }


    public void quit() {
     driver.quit();
    }
}
