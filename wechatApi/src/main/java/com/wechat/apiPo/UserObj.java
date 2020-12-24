package com.wechat.apiPo;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

/**
 * @Author: zhangcheng
 * @Description: 创建人员
 * @Date: 2020/12/23 19:09
 * @Version: 1.0
 */
public class UserObj {
    /**
     *
     * @param userid 用户id
     * @param name 用户名
     * @param alias 别名
     * @param departmentId 所属部门
     * @param accessToken
     * @param  mobile 手机号
     * @return
     */
    public static Response creatUser(String userid, String name ,String alias ,String departmentId,String mobile,String accessToken){
        String creatBody ="{\n" +
                "    \"userid\": \""+userid+"\",\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"alias\": \""+alias+"\",\n" +
                "    \"department\": \""+departmentId+"\",\n" +
                "    \"mobile\": \""+mobile+"\",\n" +
                " \n" +
                "}";

        // 信任证书
        useRelaxedHTTPSValidation();
        Response creatResponse=given().log().all()
                .proxy(8888)    //Charles 代理查看数据
                .contentType("application/json")
                .body(creatBody)
                .queryParam("access_token",accessToken)
                .post("https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token="+accessToken+"")
                .then()
                .log().body()
                .extract()
                .response()
                ;
        return creatResponse;
    }

    /**
     * 查询部门下的用户
     * @param departmentId
     * @param accessToken
     * @return
     */
    public static Response listUser(String departmentId, String accessToken){
        // 信任证书
        useRelaxedHTTPSValidation();
        Response listUserResponse = given()
                .param("access_token",accessToken)
                .param("department_id",departmentId)
                .get("https://qyapi.weixin.qq.com/cgi-bin/user/simplelist")
                .then()
                .log()
                .all()
                .extract()
                .response();
        return listUserResponse;
    }

    /**
     *  更新用户
     * @param userid
     * @param name
     * @param alias
     * @param departmentId
     * @param mobile
     * @param accessToken
     * @return
     */
    public static Response updateUser(String userid, String name ,String alias ,String departmentId,String mobile,String accessToken){
        String updateBody ="{\n" +
                "    \"userid\": \""+userid+"\",\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"alias\": \""+alias+"\",\n" +
                "    \"department\": \""+departmentId+"\",\n" +
                "    \"mobile\": \""+mobile+"\",\n" +
                " \n" +
                "}";
        // 信任证书
        useRelaxedHTTPSValidation();
        Response updateResponse=given().log().all()
                .proxy(8888)    //Charles 代理查看数据
                .contentType("application/json")
                .body(updateBody)
                .queryParam("access_token",accessToken)
                .post("https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token="+accessToken+"")
                .then()
                .log().body()
                .extract()
                .response();
        return  updateResponse;
    }


    /**
     *
     * @param userId 用户id
     * @param accessToken
     * @return
     */
    public static Response delteUser(String userId,String accessToken){
        // 信任证书
        useRelaxedHTTPSValidation();
        Response UserResponse = given()
                .param("access_token",accessToken)
                .param("userid",userId)
                .get("https://qyapi.weixin.qq.com/cgi-bin/user/delete")
                .then()
                .log()
                .all()
                .extract()
                .response();
        return UserResponse;
    }
}
