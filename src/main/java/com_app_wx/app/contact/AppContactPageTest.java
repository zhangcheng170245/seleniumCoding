package com_app_wx.app.contact;

import com_app_wx.app.AppMainPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.MalformedURLException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/11/27 16:44
 * @Description: 企业微信测试
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //使测试的方法顺序执行，需要与@TestMethodOrder结合使用，示例如下：
public class AppContactPageTest  {
    private  static AppMainPage mainPage;

    public AppContactPageTest() {
    }

    @BeforeAll
    static  void beforeAll() throws MalformedURLException {
        // 数据清理  通过借口
        mainPage = new AppMainPage();
    }

    @BeforeEach
    void beforeEach(){//进入入口
    }

    @AfterEach
    void afterEach(){//退到入口
    }

    /**
     * @MethodSource 允许您引用测试类或外部类的一个或多个工厂方法。
     * 此类工厂方法必须返回流、可迭代、迭代器或参数数组。此外，这种工厂方法不能接受任何参数。
     * 测试类中的工厂方法必须是静态的，除非用@TestInstance(Lifecycle.PER_CLASS)注释测试类;
     * 然而，外部类中的工厂方法必须始终是静态的。
     *
     * 如果只需要一个参数，可以返回参数类型实例的 Stream(流)，如下面的示例所示
     * @return
     */
    public static Stream<Arguments> data(){
        return Stream.of(
                Arguments.arguments("zhangssi","13262553523"),
                Arguments.arguments("zhangwud","13262553567"));
    }

    @MethodSource("data")
    @ParameterizedTest
    @Order(1)
    public void testAddMember(String userName, String userPhone) throws InterruptedException {
        AppContactPage appContactPage = mainPage.contact().addMember(userName, userPhone);
        assertEquals(appContactPage.getToast(), "添加成功");

    }



}
