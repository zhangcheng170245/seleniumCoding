package com.restassured;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2020/12/15 15:01
 * @Version: 1.0
 */
public class getTest {
    private static String token;

    //获取企业微信
    @BeforeAll
    public static void restGet(){
        token= given()
                .params("corpid","ww2371688596201076","corpsecret","YCx49y2eOcsEFfbPo7iPz5y096vMUESNzvYSxKp9sJU") // 提取参数
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then()
                .log().all()
                .extract().response().path("access_token"); //获取响应体的token
    }

    @Test // 企业微信发起post
    void restPost(){
        given()
                .contentType("application/json;charset=utf-8") //格式
                .body("{\n" +
                        "   \"touser\" : \"@all\",\n" +
                        "   \"msgtype\" : \"text\",\n" +
                        "   \"agentid\" : 1000002,\n" +
                        "   \"text\" : {\n" +
                        "       \"content\" : \"你的橙子已到，请携带工卡前往邮件中心领取。\\n出发前可查看<a href=\\\"http://work.weixin.qq.com\\\">邮件中心视频实况</a>，聪明避开排队。\"\n" +
                        "   },\n" +
                        "}")
                .queryParam("access_token",token)  //查询参数
                .post("https://qyapi.weixin.qq.com/cgi-bin/message/send")
                .then()
                .log().all();
    }

}
