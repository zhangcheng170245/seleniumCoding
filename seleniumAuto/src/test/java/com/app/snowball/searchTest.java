package com.app.snowball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

/**
 * @Author: zhangcheng
 * @Description: po模式
 * @Date: 2020/12/2 22:09
 * @Version: 1.0
 */
public class searchTest extends SnowBasePage {

    @ParameterizedTest
    @MethodSource("searchByNameParma")  // 参数化类
    public void searchByName(String name, String code, double price) throws InterruptedException {
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys(name);
        driver.findElement(By.xpath("//*[@text='" + code + "']")).click();
        String text = driver.findElement(By.xpath
                ("//*[@text='" + code + "']/../../..//*[@resource-id='com.xueqiu.android:id/current_price']")).getText();
        double realPrice = Double.parseDouble(text);
        System.out.println(text);
        assertThat("股票价格比对", realPrice, greaterThan(price));
        //点击取消重新搜索
        driver.findElement(By.id("com.xueqiu.android:id/action_close")).click();

    }

    /**
     * 参数化
     */
    public static Stream<Arguments> searchByNameParma() {
        return Stream.of(Arguments.of("alibaba", "BABA", 210d),
                Arguments.of("wangyi", "NTES", 250d),
                Arguments.of("Google", "GOOGL", 300d)// 名称，价格
        );   // 名称，价格1
    }
}
