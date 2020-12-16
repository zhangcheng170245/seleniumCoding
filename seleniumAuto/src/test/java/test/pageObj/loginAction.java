/*
package test.pageObj;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

*/
/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/8/27 16:35
 * @Description:
 *//*

public class loginAction {
    WebDriver webDriver;

    public loginAction( WebDriver webDriver ) {
        this.webDriver = webDriver;
    }

    //登录
    public void login(String userName, String pwd, String expected) {
        LoginPageObj loginPageObj = new LoginPageObj(webDriver);
        loginPageObj.sendKeysUserName(userName);
        loginPageObj.sendKeysPassWord(pwd);
        webDriver.findElement(loginPageObj.loginBtn).click();
        //获取弹窗提示语
        String text = webDriver.findElement(loginPageObj.errorMsg).getText();
        //断言
        Assert.assertEquals(text,expected);
    }

}
*/
