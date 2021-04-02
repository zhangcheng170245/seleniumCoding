package com.wechat.department;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: zhangcheng
 * @Description: 1.基础脚本，执行了创建，修改，查询
 * @Date: 2020/12/19 22:54
 * @Version: 1.0
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Demo1_base {
    //日志类
    private static Logger logger = LoggerFactory.getLogger(Demo1_base.class);
    static String accessToken;
    //部门id
    static String departMentId;

    @BeforeAll //脚本启动时
    public static void getAccessToken() {
        accessToken = given().log().all()
                .when()
                .param("corpid", "ww2371688596201076")
                .param("corpsecret", "okaj3sQZSWJmGneNjh4s4IHkp5RD8j3v_7ZSa8IHF6Y")
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then().log().all()  //打印出参
                .extract().response().path("access_token");  // 提取响应
    }

    @DisplayName("创建部门")
    @Test
    @Order(1)
    void createDepartment() {
        String creatBody = "{\n" +
                "   \"name\": \"广州研发中心2\",\n" +
                "   \"name_en\": \"RDGZ1\",\n" +
                "   \"parentid\": 1,\n" +
                "   \"order\": 33,\n" +
                "}\n";
        Response response = given().log().all()
                .contentType("application/json")
                .body(creatBody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=" + accessToken)
                .then().log().all()
                .extract()
                .response();
        System.out.println(response);
        //提取响应中的部门id 转义为字符串
        departMentId = response.path("id").toString();
        logger.info(accessToken);

    }

    @DisplayName("修改部门")
    @Order(2)
    @Test
    void updateDepartment() {
        String updateBody = "{\n" +
                "   \"name\": \"部门id\",\n" +
                "   \"name_en\": \"RDGZ\",\n" +
                "   \"parentid\": 1,\n" +
                "   \"order\": 1,\n" +
                "   \"id\":" + departMentId + "\n" +
                "}\n";
        Response response = given().log().all()
                .contentType("application/json")
                .body(updateBody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token" + accessToken)
                .then().log().all()
                .extract().response();
        System.out.println(response);
        assertEquals(0, response.<Integer>path("errcode").toString());
    }

    @DisplayName("查询部门")
    @Order(3)
    @Test
    void queryDepartment() {
        Response response = given().log().all()
                .when()
                .param("id", departMentId)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=" + accessToken)
                .then().log().all()
                .extract().response();
        System.out.println(response);
        assertEquals(0, response.<Integer>path("errcode").toString());
        assertEquals(0, response.<Integer>path("department.id[0]").toString());
    }

    @DisplayName("删除部门")
    @Order(4)
    @Test
    void deleteDepartment() {
        Response response = given().log().all()
                .contentType("application/json")
                .when()
                .param("id", departMentId)
                .param("access_token", accessToken)
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token")
                .then().log().all()
                .extract().response();
        System.out.println(response);
        assertEquals(0, response.<Integer>path("errcode").toString());
    }

}
