package com.restassured;

import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.wechat.utils.RequestUtil;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
import static io.restassured.RestAssured.*;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsd;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2020/12/15 11:58
 * @Version: 1.0
 */
public class restDemo {

    private static RequestUtil requestUtil;

    //语法糖 get请求
    @Test
    void restGet() {
        given()
                .get("https://www.baidu.com/")
                .then()
                .statusCode(200)
                .log().all();
    }

    // 验证返回参数 int类型
    @Test
    void assertJson() {
        given()
                .get("http://127.0.0.1:8888/litty")
                .then()
                // import static org.hamcrest.Matchers.*;
                .body("litty.littyId", equalTo(5));
    }

    //find 和findall 用法
    @Test
    void assertJsonFind() {
        given()
                .when()
                .log().all().get("http://127.0.0.1:8888/litty")
                .then()
                .log().all()
                // 我们可以在findAll方法中写筛选条件，例如我们想取winnerId的值在大于或等于30小于60之间的结果进行断言，具体写法如下：
                .body("litty.winners.find{ winners -> winners.winnerId >= 30 && winners.winnerId < 60}.winnerId", equalTo(54));
    }


    @Test
    void assertJsonA() { // 验证数据是否包含  hasItem
        given()
                .get("http://127.0.0.1:8888/litty")
                .then()
                // import static org.hamcrest.Matchers.*;
                .body("litty.littyId", hasItems(5, 2));
    }

    // 验证返回参数 float类型
    @Test
    //默认情况下您验证price字段是否等于float类型
    void assertJsonDouble() {
        given()
                .get("http://127.0.0.1:8889/price")
                .then()
                // import static org.hamcrest.Matchers.*;
                .body("price", is(12.12f));
    }


    //Java在java.math包中提供的API类BigDecimal，用来对超过16位有效位的数进行精确的运算）
    @Test
    void assertJsonBigDecimal() {
        given()
                .config(RestAssured.config().jsonConfig(jsonConfig().numberReturnType(io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL)))
                .when()
                .get("http://127.0.0.1:8889/price")
                .then()
                // import static org.hamcrest.Matchers.*;
                .body("price", is(12.12f));
    }

    @Test
    void assertJsonNIMING() { // 匿名根节点 使用 $或者空 代替根节点
        given()
                .get("http://127.0.0.1:8888/litty")
                .then()
                // import static org.hamcrest.Matchers.*;
                .body("$", hasItems(5, 2));
    }


    //schema验证(/products)这个请求是否符合规范：
    @Test
    void restSchemaDemo() {
        given()
                .get("http://localhost:8889/litty")
                .then().assertThat()
                .body(matchesJsonSchemaInClasspath("products-schema.json"));

    }


    // todo JSON Schema Validation 设置项
    @Test
    void testSchemaSet() {
        // 使用Francis Galiegue的json-schema-validator (fge) 库来进行验证。 如果您想配置使用基础fge库
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
                .setValidationConfiguration(ValidationConfiguration.newBuilder().setDefaultVersion(DRAFTV4).freeze()).freeze();
        // When
        get("http://localhost:8889/litty")
                .then().assertThat()
                .body(matchesJsonSchemaInClasspath("products-schema.json").using(jsonSchemaFactory));
    }

    //todo xml解析
    @Test
    void testXml() {
        proxy(8888);
        with().formParams("firstName", "jack", "lastName", "lovey")
                .when()
                .post("http://localhost:8889/getxml")
                .then()
                .body("greeting.firstName", equalTo("jack"), "greeting.lastName", equalTo("lovey"));
        //在请求中返还了一个基于firstname和lastname请求参数的greeting节点。您可以通过rest-assured轻易地展现和解析这个例子
    }

    //TODO xml XPATH校验
    @Test
    void testXmlXpath() {
        proxy(8888);  // charles 代理端口
        with().formParams("firstName", "jack", "lastName", "lovey")
                .when()
                .post("http://localhost:8889/getxml")
                .then()
                // 第一种写法     .body(hasXPath("/greeting/firstName[text()='jack']"));
                //第二种写法
                .body(hasXPath("/greeting/firstName", containsString("ja")));
    }

    //xsd 文档校验
    @Test
    void testXsd() {
        File file = new File("H:\\ideawork\\seleniumCoding\\mockProject\\src\\main\\resources\\XSD\\assertxml.xml");
        given()
                .proxy(8888)
                .when()
                //assertxmlJSON
                .get("http://localhost:8889/getresponsewithfile")
                .then()
                .assertThat() // 断言
                .body(matchesXsd(file));////接口返回内容是xml，需要把xml转换成xml schema，然后生成一个文件，把文件传过来作为参数

    }

    @Test
    void assertCookie() {
        given().proxy(8888)
                .when()
                .get("http://localhost:8889/getCookies")
                .then()
                .cookie("login", "true");
    }

    @Test
    void assertCookieany() {
        given().proxy(8888)
                .when()
                .get("http://localhost:8889/getanyCookies")
                .then()
                .cookies("login", "true", "code", "200");
    }


    @Test
    void assertCode() {
        given().proxy(8888)
                .when()
                .get("http://localhost:8889/getanyCookies")
                .then()
                .assertThat()
                //      .statusCode(200);
                .statusLine("HTTP/1.1 200 OK");
    }

    @Test
    void assertStatusLine() {
        given().proxy(8888)
                .when()
                .get("http://localhost:8889/getanyCookies")
                .then()
                .assertThat()
                //      .statusCode(200);
                .statusLine(containsString("200"));
    }

    @Test
    void assertHear() throws Exception {
        requestUtil.sendgetWithHttps("https://testerhome.com", "/api/v3/topics.json")
                .assertThat()
                .header("Connection", "keep-alive");
    }

    @Test
    void assertHearmore() throws Exception {
        requestUtil.sendgetWithHttps("https://testerhome.com", "/api/v3/topics.json")
                .assertThat()
                .headers("Connection", "keep-alive", "Transfer-Encoding", "chunked");
    }

    //验证“Content-Length”头部小于1000
    @Test
    void assertHearlength() throws Exception {
        requestUtil.sendgetWithHttps("https://testerhome.com", "/api/v3/topics.json")
                .assertThat()
                .header("Content-Length", Integer::parseInt, lessThan(1000));


    }
}