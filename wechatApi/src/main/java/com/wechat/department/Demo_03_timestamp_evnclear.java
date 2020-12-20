package com.wechat.department;

import com.wechat.utils.FakerUtils;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: zhangcheng
 * @Description: 解耦的脚本
 * @Date: 2020/12/20 17:52
 * @Version: 1.0
 *  * 1、基础脚本，分别执行了，创建、修改、查询、删除接口并进行了校验
 *  * 2、进行了优化，方法间进行解耦，每个方法可以独立行
 *    3  时间戳命令防止重名
 *    4、进行了优化，每次方法执行前后都对历史数据进行清理，确保每次执行脚本数据环境一致。
 *  */

public class Demo_03_timestamp_evnclear {
    private static final Logger logger = LoggerFactory.getLogger(Demo_03_timestamp_evnclear.class);

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
    //数据清理  每次用例启动结束时执行
    @BeforeEach
    @AfterEach
    void clearDepartment(){
        Response listResponse= given().log().all()    // 响应列表
                .when()
                .param("id",1)   //跟部门id为1
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token="+accessToken)
                .then()
                .log().body()
                .extract()
                .response();
        ArrayList<Integer> departmentIdList = listResponse.path("department.id");// 获取部门id
        //遍历
        for (int departmentId:departmentIdList) {
            if (1 == departmentId){  //查找根节点
                continue;
            }
            Response delResponse =  given().log().all()  // 删除不是根目录的部门信息
                    .contentType("application/json")
                    .param("access_token",accessToken)
                    .param("id",departmentId)
                    .get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                    .then()
                    .log().body()
                    .extract().response();
        }
    }

    @DisplayName("创建部门")
    @Test
    @Order(1)
    void createDepartment() {
        // 姓名添加时间戳 防重
        String name= "橙子大王"+ FakerUtils.getTimeStamp();
        String enName="enName"+FakerUtils.getTimeStamp();
        String body ="{\n" +
                "   \"name\": \""+name+"\",\n" +
                "   \"name_en\": \""+enName+"\",\n" +
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
        // 姓名添加时间戳 防重
        String name= "橙子大王"+ FakerUtils.getTimeStamp();
        String enName="enName"+FakerUtils.getTimeStamp();
        String creatBody ="{\n" +
                "   \"name\": \""+name+"\",\n" +
                "   \"name_en\": \""+enName+"\",\n" +
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
                "   \"name\": \""+name+"\",\n" +
                "   \"name_en\": \""+enName+"\",\n" +
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
        // 姓名添加时间戳 防重
        String name= "橙子大王"+ FakerUtils.getTimeStamp();
        String enName="enName"+FakerUtils.getTimeStamp();
        String creatBody ="{\n" +
                "   \"name\": \""+name+"\",\n" +
                "   \"name_en\": \""+enName+"\",\n" +
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
        // 姓名添加时间戳 防重
        String name= "橙子大王"+ FakerUtils.getTimeStamp();
        String enName="enName"+FakerUtils.getTimeStamp();
        String creatBody ="{\n" +
                "   \"name\": \""+name+"\",\n" +
                "   \"name_en\": \""+enName+"\",\n" +
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