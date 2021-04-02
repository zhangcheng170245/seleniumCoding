package com.zz.wx.actions;

import com.zz.wx.global.GlobalVariables;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author:     zhangcheng
 * @Description:
 * @Date:    2021/3/24/024 22:56
 * @Version:    1.0
 */class zcApiActionModelTest {
    public static final Logger logger = LoggerFactory.getLogger(zcApiActionModelTest.class);

    @Test
    void  runTest(){
        //测试数据
        ArrayList<String> actualParameter = new ArrayList<>();
        actualParameter.add("ww2371688596201076");
        actualParameter.add("okaj3sQZSWJmGneNjh4s4IHkp5RD8j3v_7ZSa8IHF6Y");

        zcApiActionModel apiActionModel = new zcApiActionModel();
        // 请求地址 测试global变量替换
        apiActionModel.setUrl("https://qyapi.weixin.qq.com/cgi-bin/${x}");
        HashMap<String ,String> globalVariables = new HashMap<>();
        globalVariables.put("x","gettoken");
        // 赋值到静态变量全局共享
        GlobalVariables.setGlobalVariables(globalVariables);
        // 模拟形式 参数
        ArrayList<String> formalParameter = new ArrayList<>();
        formalParameter.add("corpid");
        formalParameter.add("corpsecret");

        apiActionModel.setFormalParam(formalParameter);

        HashMap<String, String> query = new HashMap<>();
        query.put("corpid","${corpid}");
        query.put("corpsecret","${corpsecret}");

        apiActionModel.setQuery(query);


        Response response=apiActionModel.run(actualParameter);
    }

}