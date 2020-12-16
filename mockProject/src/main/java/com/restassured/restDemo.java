package com.restassured;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.config.JsonConfig.jsonConfig;
import static org.hamcrest.Matchers.*;

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

    // 验证返回参数 int类型
    @Test
    void assertJson(){
        given()
                .get("http://127.0.0.1:8888/litty")
                .then()
                // import static org.hamcrest.Matchers.*;
                .body("litty.littyId",equalTo(5));
    }

    @Test
    void assertJsonA(){ // 验证数据是否包含  hasItem
        given()
                .get("http://127.0.0.1:8888/litty")
                .then()
                // import static org.hamcrest.Matchers.*;
                .body("litty.littyId",hasItem(5));
    }

    // 验证返回参数 float类型
    @Test //默认情况下您验证price字段是否等于float类型
    void assertJsonDouble(){
        given()
                .get("http://127.0.0.1:8889/price")
                .then()
                // import static org.hamcrest.Matchers.*;
                .body("price",is(12.12f));
    }


    //Java在java.math包中提供的API类BigDecimal，用来对超过16位有效位的数进行精确的运算）
    @Test
    void assertJsonBigDecimal(){
             given()
                .config(RestAssured.config().jsonConfig(jsonConfig().numberReturnType(io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL)))
                .when()
                .get("http://127.0.0.1:8889/price")
                .then()
                // import static org.hamcrest.Matchers.*;
                .body("price", is(12.12f));
    }

}
