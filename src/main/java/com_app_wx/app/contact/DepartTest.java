package com_app_wx.app.contact;

import com_app_wx.app.AppMainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/11/24 21:49
 * @Description:
 */
public class DepartTest {
    private  static AppMainPage mainPage;

    public DepartTest() {
    }

    @BeforeAll
    static  void beforeAll() throws MalformedURLException {
        // 数据清理  通过借口
        mainPage = new AppMainPage();




    }

    @BeforeEach
    void beforeEach(){
        //进入入口

    }

    @AfterEach
    void afterEach(){
        //退到入口
    }



    @ParameterizedTest
    @ValueSource(strings = {"xx", "中文", "a_b", "a b", "xxx（）有限公司"})
    void  add(String name){
        assertTrue(mainPage.contact().addDepart(name).search(name).getName().contains(name));
    }

    @Test
    @ValueSource(strings = {"xxxxxxxxxxxxxxx", "youxiangongsi", "中"})
    void  search(String name){
        assertEquals(name,mainPage.contact().addDepart(name).search(name).getName());
    }

    @ParameterizedTest
    @CsvSource({
            "旧的部门1,新的部门",
    })
    void  update(String name,String newDepartName) throws InterruptedException {
        assertEquals(newDepartName,mainPage.contact().addDepart(name).update(name,newDepartName));
        System.out.println("修改成功");
    }

    @ParameterizedTest
    @CsvSource({
            "gggg"
    })
    void  delete(String name) throws InterruptedException {
          mainPage.contact().clearDepart(name);
        assertEquals("无",mainPage.contact().search(name).getName());


    }
}
