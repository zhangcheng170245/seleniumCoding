package com.apiobject.framework.actions;

import com.apiobject.framework.actions.global.GlobalVariales;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: zhangcheng
 * @Description: 对ApiAction接口动作对象实现的单元测试
 * @Date: 2020/12/27 17:17
 * @Version: 1.0
 */
class ApiActionModelTest {

    public static final Logger logger = LoggerFactory.getLogger(ApiActionModelTest.class);

    @Test
    void runTest(){
        ArrayList<String> actualParameter = new ArrayList<>();
        actualParameter.add("ww2371688596201076");
        actualParameter.add("okaj3sQZSWJmGneNjh4s4IHkp5RD8j3v_7ZSa8IHF6Y");
        logger.info(actualParameter.toString());

        ApiActionModel apiActionModel = new ApiActionModel();
        apiActionModel.setUrl("https://qyapi.weixin.qq.com/cgi-bin/gettoken");

        HashMap<String, String> globalVariables = new HashMap<>(); //全局变量
        globalVariables.put("x","gettoken"); // x赋值为 gettoken

        GlobalVariales.setGlobalVariales(globalVariables);

        ArrayList<String> formalParameter = new ArrayList<>(); //形参
        formalParameter.add("corpid");
        formalParameter.add("corpsecret");
        apiActionModel.setFormalParam(formalParameter);

        //赋值查询参数
        HashMap<String, String> query = new HashMap<>();
        query.put("corpid","${corpid}");
        query.put("corpsecret","${corpsecret}");

        apiActionModel.setQuery(query);
        Response response= apiActionModel.run(actualParameter);
    }
}