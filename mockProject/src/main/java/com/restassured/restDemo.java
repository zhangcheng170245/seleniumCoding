package com.restassured;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2020/12/15 11:58
 * @Version: 1.0
 */
public class restDemo {


    //语法糖 get请求
    @Test
    void restGet(){
        given()
                .get("https://www.baidu.com/")
                .then()
                .statusCode(200)
                .log().all();

    }
}
