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
                .param("corpid","ww2371688596201076")
                .param("corpsecret","okaj3sQZSWJmGneNjh4s4IHkp5RD8j3v_7ZSa8IHF6Y")
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then()
                .extract().response().path("access_token");  // 提取响应
        return accessToken;
    }
}
