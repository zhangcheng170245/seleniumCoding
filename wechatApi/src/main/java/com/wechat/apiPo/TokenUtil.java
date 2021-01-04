package com.wechat.apiPo;

import static io.restassured.RestAssured.given;

/**
 * @Author: zhangcheng
 * @Description: 获取token
 * @Date: 2020/12/20 22:55
 * @Version: 1.0
 */
public class TokenUtil {
    public static String  getAccessToken(){
      String  accessToken=given()
                .when()
                .param("corpid","ww2371688596201076")  //企业id
                .param("corpsecret","okaj3sQZSWJmGneNjh4s4IHkp5RD8j3v_7ZSa8IHF6Y")  //企业密钥
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken") // 请求地址
                .then()
                .extract().response().path("access_token");  // 提取响应
        return accessToken;
    }
}
