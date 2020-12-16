package test_web.wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/8/31 07:51
 * @Description:联系人
 */
public class ContactPage extends  BasePage {
    //提取
    By addMember=By.linkText("添加成员");
    By username=By.name("username");
    By delete=By.linkText("删除");

    public ContactPage( RemoteWebDriver driver ) {
       super(driver);
    }


    public ContactPage addMermber(String username,String acctid ,String mobile){
        //姓名为空 点击新增
        while (driver.findElements(this.username).size()==0){
          click(addMember);
        }
/*     driver.findElement(this.username).sendKeys(username);
     driver.findElement(By.name("acctid")).sendKeys(acctid);
     driver.findElement(By.name("mobile")).sendKeys(mobile);
        //保存
     driver.findElement(By.cssSelector(".js_btn_save")).click();*/
        sendKeys(this.username,username);
        sendKeys(By.name("acctid"), acctid);
        sendKeys(By.name("mobile"), mobile);
        click(By.cssSelector(".js_btn_save"));
        return this;
    }

    // search
    public  ContactPage search (String keyword){
       //driver.findElement(By.id("memberSearchInput")).sendKeys(keyword);
        sendKeys(By.id("memberSearchInput"),keyword);
        return this;
    }
    public ContactPage delete(){
    /* driver.findElement(delete).click();
     driver.findElement(By.linkText("确认")).click();
     driver.findElement(By.id("clearMemberSearchInput")).click();*/

    click(delete);
    click(By.linkText("确认"));
    click(By.id("clearMemberSearchInput"));
        return this;

    }

    public String getUserName(){
        return driver.findElement(By.cssSelector(".member_display_cover_detail_name")).getText();
    }


    //上传
    public ContactPage importFromFile( URL path){

        System.out.println(path.getPath());

        String path_utf="";
        try {
            path_utf= URLDecoder.decode(path.getFile(), "UTF-8");
            System.out.println(path_utf);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        click(By.cssSelector(".ww_operationBar:nth-child(1) .ww_btn_PartDropdown_left"));
        click(By.linkText("文件导入"));
        sendKeys(By.name("file"),"H:\\mall\\test_selenium\\src\\main\\resources\\通讯录批量导入模板.xlsx");
        click(By.linkText("导入"));
        click(By.linkText("完成"));
        return this;

    }



}
