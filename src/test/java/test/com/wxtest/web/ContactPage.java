package test.com.wxtest.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class ContactPage extends BasePage {
    private By searchDepartInput = By.id("memberSearchInput");
    private By dpartInfo = By.className("js_party_info");
    private By addDpartBtn = By.cssSelector(".member_colLeft_top_addBtn");
    private By addDpart = By.linkText("添加部门");
    private By addDpartName = By.name("name");
    private By selectBelongDepart = By.className("js_parent_party_name");
    private By updateDepartNameBtn = By.className("js_mod_party_name");
    private By departRename = By.cssSelector(".js_rename_input");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    //搜索部门
    //po原则5 不需要实现所有的方法，按需封装
    public ContactPage searchDepart(String departName) {
        //点击联系人按钮
        click(By.id("menu_contacts"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sendKeys(searchDepartInput, departName);
        click(By.cssSelector(".ww_icon_AddMember"));
        return this;
    }

    //添加部门
    ContactPage addDepart(String departName) throws InterruptedException {
        click(By.id("menu_contacts"));
        Thread.sleep(3000);
        click(By.linkText("添加"));
        click(By.className("js_create_party"));
        sendKeys(By.name("name"),departName);
        click(By.linkText("选择所属部门"));
        Thread.sleep(2000);
        driver.findElements(By.linkText("面向对象")).get(1).click();
        click(By.linkText("确定"));
        Thread.sleep(1000);

        return this;
    }

    //更新部门名称
    ContactPage updateDepartName(String newDepartName) throws InterruptedException {
        //click(By.id("menu_contacts"));
        Thread.sleep(3000);
        sendKeys(searchDepartInput, newDepartName);
        click(updateDepartNameBtn);
        clear(departRename);
        sendKeys(departRename, newDepartName);
        click(By.linkText("保存"));
        return this;
    }


    //获取部门信息
    String getDepartInfo() {
        waitElem(dpartInfo);
        String content = getText(dpartInfo);
        System.out.println(content);
        return content;
    }

    String getDpartList() {
        return getText(By.className("member_colLeft_bottom"));
    }

    //清楚部门信息
    void clearAllDeparts() {
        click(By.id("menu_contacts"));
        try {
            sendKeys(searchDepartInput, "depart1116");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //校验部门是否存在，是否需要删除成员
        if (getDpartList().contains("depart1116")) {
            if (!getDepartInfo().contains("无任何成员")) {
                deleteAllMems();
            }
            //删除搜索框信息
            click(By.id("clearMemberSearchInput"));
            driver.findElements(By.linkText("depart1116")).get(0).click();
            //选中删除的部门，定位侧边操作栏
            //点击删除按钮
            driver.findElements(By.cssSelector("span.icon.jstree-contextmenu-hover")).get(3).click();
            waitElem((By.linkText("删除")));
            click(By.linkText("删除"));
            click(By.linkText("确定"));
        } else {
            System.out.println("无部门信息");
        }
    }


    //添加成员
    ContactPage addMember(String username, String acctid, String mobile) throws InterruptedException {
       //点击联系人
        click(By.id("menu_contacts"));
        click(By.linkText("添加成员"));
        Thread.sleep(3000);
        sendKeys(By.name("username"), username);
        sendKeys(By.name("acctid"), acctid);
        sendKeys(By.name("mobile"), mobile);
        click(By.linkText("保存"));
        Thread.sleep(1000);
        return this;
    }


    //添加成员失败
    ContactPage addMemberFail(String username, String mobile) {
        click(By.linkText("添加成员"));
        sendKeys(By.name("username"), "wuww");
        sendKeys(By.name("memberAdd_phone"), "12345678901");
        click(By.linkText("保存"));
        return this;
    }


    //删除所有成员
    ContactPage deleteAllMems() {
        click(By.className("member_colRight_memberTable_th_Checkbox"));
        click(By.linkText("删除"));
        waitElem(By.linkText("确认"));
        click(By.linkText("确认"));
        return this;
    }

    //修改成员邮箱信息
    ContactPage modifyMemEmail(String departName, String memName,String email) {
        if (searchDepart(departName).getDepartInfo().contains(memName)) {
            click(By.linkText(memName));
            click(By.linkText("编辑"));
            sendKeys(By.name("alias"),email);
            click(By.linkText("保存"));
        } else {
            System.out.println("成员不存在");
        }
        return this;
    }

    String getMemEmail(){
        return getText(By.className("member_display_item member_display_item_Email"));
    }



}