package com.wechat.department;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: zhangcheng
 * @Description: 解耦的脚本
 * @Date: 2020/12/20 17:52
 * @Version: 1.0
 *  * 1、基础脚本，分别执行了，创建、修改、查询、删除接口并进行了校验
 *  * 2、进行了优化，方法间进行解耦，每个方法可以独立行
 *  */

public class Demo_02_separate {
    private static final Logger logger = LoggerFactory.getLogger(Demo_02_separate.class);

    static String accessToken;
    static String departmentId;

    @BeforeAll
    public  static  void  getAccessToken(){
        accessToken=given().log().all()
                .when()
                .param("corpid","ww2371688596201076")
                .param("corpsecret","okaj3sQZSWJmGneNjh4s4IHkp5RD8j3v_7ZSa8IHF6Y")
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then().log().all()  //打印出参
                .extract().response().path("access_token");  // 提取响应
    }

    @DisplayName("创建部门")
    @Test
    @Order(1)
    void createDepartment() {
        String body ="{\n" +
                "   \"name\": \"我是橙子大王\",\n" +
                "   \"name_en\": \"orange\",\n" +
                "   \"parentid\": 1}";
        final Response response=given().log().all()
                .contentType("application/json")
                .body(body)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+accessToken+"")
                .then()
                .log().body()
                .extract()
                .response()
                ;
        departmentId=response.path("id")!=null ? response.path("id").toString():null;
        assertEquals("0",response.path("errcode").toString());

    }
    @DisplayName("修改部门")
    @Test
    @Order(2)
    void updateDepartment() {
        String creatBody ="{\n" +
                "   \"name\": \"我是橙子大王\",\n" +
                "   \"name_en\": \"orange\",\n" +
                "   \"parentid\": 1}";
        final Response creatResponse=given().log().all()
                .contentType("application/json")
                .body(creatBody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+accessToken+"")
                .then()
                .log().body()
                .extract()
                .response()
                ;
        String departmentId=creatResponse.path("id")!=null ? creatResponse.path("id").toString():null;
        String updateBody ="{\n" +
                "   \"id\": "+departmentId+",\n" +
                "   \"name\": \"我是橙子小王\",\n" +
                "   \"name_en\": \"oranges\",\n" +
                "   \"order\": 1\n" +
                "}\n";
        Response updateResponse=given().log().all()
                .contentType("application/json")
                .body(updateBody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token="+accessToken+"")
                .then()
                .log().body()
                .extract().response();
        assertEquals("0",updateResponse.path("errcode").toString());

    }

    @DisplayName("查询部门")
    @Test
    @Order(3)
    void listDepartment() {
        String creatBody ="{\n" +
                "   \"name\": \"我是橙子大王\",\n" +
                "   \"name_en\": \"orange\",\n" +
                "   \"parentid\": 1}";
        final Response creatResponse=given().log().all()
                .contentType("application/json")
                .body(creatBody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+accessToken+"")
                .then()
                .log().body()
                .extract()
                .response()
                ;
        String departmentId=creatResponse.path("id")!=null ? creatResponse.path("id").toString():null;
        Response response =given().log().all()
                .when()
                .param("id",departmentId)
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token="+accessToken)
                .then()
                .log().body()
                .extract()
                .response();
        assertEquals("0",response.path("errcode").toString());
        assertEquals(departmentId,response.path("department.id[0]").toString());

    }
    @DisplayName("删除部门")
    @Test
    @Order(4)
    void deleteDepartment() {
        String creatBody ="{\n" +
                "   \"name\": \"我是橙子大王\",\n" +
                "   \"name_en\": \"orange\",\n" +
                "   \"parentid\": 1}";
        final Response creatResponse=given().log().all()
                .contentType("application/json")
                .body(creatBody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+accessToken+"")
                .then()
                .log().body()
                .extract()
                .response()
                ;
        String departmentId=creatResponse.path("id")!=null ? creatResponse.path("id").toString():null;
        Response response = given().log().all()
                .contentType("application/json")
                .param("access_token",accessToken)
                .param("id",departmentId)
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                .then()
                .log().body()
                .extract().response()
                ;
        assertEquals("0",response.path("errcode").toString());

    }
}