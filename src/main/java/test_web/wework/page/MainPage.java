package test_web.wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/8/31 00:15
 * @Description:首页
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
        driver.manage().addCookie(new Cookie("RK", "0WpIhS8MZm"));
        driver.manage().addCookie(new Cookie("ptcz", "d5f2b3bf82098db0d0bb9e659fa611ab8da428f086df79fc04ac856dfc0e176a"));
        driver.manage().addCookie(new Cookie("pgv_pvid", "1854058240"));
        driver.manage().addCookie(new Cookie("pgv_pvi", "3880951808"));
        driver.manage().addCookie(new Cookie("tvfe_boss_uuid", "cfa637ad4e6d3735"));
        driver.manage().addCookie(new Cookie("eas_sid", "K1p5G6x7U8a5X8G7f394o9i5E0"));
        driver.manage().addCookie(new Cookie("uin_cookie", "o0170902823"));
        driver.manage().addCookie(new Cookie("ied_qq", "o0170902823"));
        driver.manage().addCookie(new Cookie("LOLWebSet_AreaBindInfo_170902823", "%257B%2522areaid%2522%253A%25223%2522%252C%2522areaname%2522%253A%2522%25E7%25A5%2596%25E5%25AE%2589%2520%25E7%2594%25B5%25E4%25BF%25A1%2522%252C%2522sRoleId%2522%253A0%252C%2522roleid%2522%253A%2522170902823%2522%252C%2522rolename%2522%253A%2522%25E6%2595%2585%25E5%259C%25B0%25E6%2598%25AF%25E4%25BD%2595%25E5%259C%25B0%2522%252C%2522checkparam%2522%253A%2522lol%257Cyes%257C170902823%257C3%257C170902823*%257C%257C%257C%257C%2525E6%252595%252585%2525E5%25259C%2525B0%2525E6%252598%2525AF%2525E4%2525BD%252595%2525E5%25259C%2525B0*%257C%257C%257C1568374788%2522%252C%2522md5str%2522%253A%25227115977216276D7C47CCE1039803AB32%2522%252C%2522roleareaid%2522%253A%25223%2522%252C%2522sPartition%2522%253A%25223%2522%257D"));
        driver.manage().addCookie(new Cookie("o_cookie", "170902823"));
        driver.manage().addCookie(new Cookie("LW_uid", "D1S5p7K7F8G4m6d1Z1G2s9b9f9"));
        driver.manage().addCookie(new Cookie("XWINDEXGREY", "0"));
        driver.manage().addCookie(new Cookie("pac_uid", "1_170902823"));
        driver.manage().addCookie(new Cookie("luin", "o0170902823"));
        driver.manage().addCookie(new Cookie("lskey", "000100002680b2b3f46233a9e1b82f7781ed31953884ba64d63fa1a46953ddbd01bce51034584b5e3470884a"));
        driver.manage().addCookie(new Cookie("LW_sid", "41i5x998y0A1F3E8Z9D5m7T9B3"));
        driver.manage().addCookie(new Cookie("wwrtx.c_gdpr", "0"));
        driver.manage().addCookie(new Cookie("_ga", "GA1.2.556989742.1598615025"));
        driver.manage().addCookie(new Cookie("same_pc", "%7B%7D"));
        driver.manage().addCookie(new Cookie("_gid", "GA1.2.55163299.1598790969"));
        driver.manage().addCookie(new Cookie("wwrtx.ref", "direct"));
        driver.manage().addCookie(new Cookie("wwrtx.refid", "112083115988811"));
        driver.manage().addCookie(new Cookie("wwrtx.i18n_lan_custom", "true"));
        driver.manage().addCookie(new Cookie("wwrtx.i18n_lan", "zh-cn"));
        driver.manage().addCookie(new Cookie("wwrtx.ltype", "1"));
        driver.manage().addCookie(new Cookie("wxpay.corpid", "1970325031154960"));
        driver.manage().addCookie(new Cookie("wxpay.vid", "1688853852988095"));
        driver.manage().addCookie(new Cookie("wwrtx.vid", "1688853852988095"));
        driver.manage().addCookie(new Cookie("uin", "o0170902823"));
        driver.manage().addCookie(new Cookie("skey", "@LdT9N8S2a"));
        driver.manage().addCookie(new Cookie("pgv_info", "ssid=s9428063456"));
        driver.manage().addCookie(new Cookie("Hm_lvt_9364e629af24cb52acc78b43e8c9f77d", "1598797409,1598862677"));
        driver.manage().addCookie(new Cookie("Hm_lpvt_9364e629af24cb52acc78b43e8c9f77d", "1598862677"));
        driver.manage().addCookie(new Cookie("ww_rtkey", "71ckt8m"));
        driver.manage().addCookie(new Cookie("_gat", "1"));
        driver.manage().addCookie(new Cookie("wwrtx.d2st", "a8375514"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "B-JlQAJAKuwt-5_SlKKnqx0ua1mnOjzAOlW7ywbRuJ7WmstueNCRY3J1boYBwI63"));
        driver.manage().addCookie(new Cookie("wwrtx.vst", "TMTe_Soxlg0aC6i9mjdjRUBj7i4Cdm-xw7XWYbjiIjNfWrYPB4YolL8r6rPM52gEqDLEOkxgzGKh2wKn2_jwUhmdddbE0GhzABBvRPhVcu2idXAuBFw3CLskVJLFE_qeKkysL_c5pmnwKUnT50TdA15Kk5iNe-BUVq76wslch7JMCxUyQ2LENfW-7pVbMc4zi8_WyHWxovCDLrjhTsOutlkziqUUBWb1GsGUl29BzgWZ67FnJ0zv1ftBAIDYR0oRif58izV4zuRi4hDjkxzCnQ"));

        System.out.println(driver.manage().getCookies());

        driver.get(url);

    }

    public ContactPage toContact(){
        //通过定位符 点击联系人
      //  driver.findElement(By.cssSelector("#menu_contacts")).click();
        click(By.cssSelector("#menu_contacts"));
        return  new  ContactPage(driver);
    }


    public void quit() {
        driver.quit();
    }
}
