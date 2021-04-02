/*
package com.zz.test;

import com.zz.wx.actions.zcApiActionModel;
import com.zz.wx.global.GlobalVariables;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;

*/
/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/20/020 11:28
 * @Version: 1.0
 *//*

class ApiActionModelTest {
    public static final Logger logger = LoggerFactory.getLogger(ApiActionModelTest.class);

    @Test
    void runTest(){
        ArrayList<String> actualParameter = new ArrayList<>();
        actualParameter.add("ww2371688596201076");
        actualParameter.add("okaj3sQZSWJmGneNjh4s4IHkp5RD8j3v_7ZSa8IHF6Y");

  */
/*      ApiObjectModel apiObjectModel= ApiObjectModel.load("src/test/resources/api/tokenhelper.yaml");
        apiObjectModel.getActions().get("getToken").run(actualParameter);
*//*

        zcApiActionModel apiActionModel = new zcApiActionModel();
        apiActionModel.setUrl("https://qyapi.weixin.qq.com/cgi-bin/${x}");
        //模拟替换路径
        HashMap<String ,String> globalVariables = new HashMap<>();
        // 测试将x变量替换为 gettoken
        globalVariables.put("x","gettoken");
        //静态变量全局共享
        GlobalVariables.setGlobalVariables(globalVariables);
        ArrayList<String> formalParameter = new ArrayList<>();

        formalParameter.add("corpid");
        formalParameter.add("corpsecret");
        apiActionModel.setFormalParam(formalParameter);

        HashMap<String ,String> query = new HashMap<>();
        query.put("corpid","${corpid}");
        query.put("corpsecret","${corpsecret}");

        apiActionModel.setQuery(query);

        Response response = apiActionModel.run(actualParameter);

    }




}*/
