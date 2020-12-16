package test.com.wxtest.web;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertTrue;

public class ContactPOTest {

    private static MainPage main;

    @BeforeAll
    static  void  beforeAll() throws IOException, InterruptedException {
        main=new MainPage();
        //TODO    新增清除数据
    }


    @Test
    @Order(1)
    @DisplayName("添加成员")
    public void addMem() throws InterruptedException {
        main.contactPage().addMember("005","210093","13262553509");
    }

    @Test
    @Order(2)
    @DisplayName("搜索部门")
    public void searchDepart() throws InterruptedException {
        String departInfo = main.contactPage().searchDepart("财务部").getDepartInfo();
        Thread.sleep(3000);
        assertTrue(departInfo.contains("当前部门无任何成员"));
    }

    @Test
    @Order(3)
    @DisplayName("添加部门")
    public void addDepart() throws InterruptedException {
        String departInfo = main.contactPage().addDepart("吹B部").getDepartInfo();
        Thread.sleep(3000);
        assertTrue(departInfo.contains("吹B部"));
    }

    @Test
    @Order(4)
    @DisplayName("更新部门名称")
    public void updateDepart() throws InterruptedException {
        String departInfo = main.contactPage().updateDepartName("吹水部").getDepartInfo();
        Thread.sleep(3000);
        assertTrue(departInfo.contains("吹水部"));
    }






}

