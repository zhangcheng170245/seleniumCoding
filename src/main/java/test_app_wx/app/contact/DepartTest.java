package test_app_wx.app.contact;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test_app_wx.app.AppMainPage;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/11/22 14:00
 * @Description:
 */
public class DepartTest {

    private  static AppMainPage mainPage;

    public DepartTest() {
    }

    @BeforeAll
    static  void beforeAll() throws MalformedURLException {
         // TODO: 2020/11/22  数据清理  通过借口
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

    @Test
    void  update(){

    }

    @Test
    void  delete(){

    }
}
