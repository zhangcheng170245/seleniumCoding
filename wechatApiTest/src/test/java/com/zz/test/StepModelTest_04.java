/*
package com.zz.test;

import com.zz.wx.global.ApiLoader;
import com.zz.wx.steps.AssertModel;
import com.zz.wx.steps.StepModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

*/
/**
 * @Author: zhangcheng
 * @Description: 测试用例点
 *
 * @Date: 2021/3/20/020 20:35
 * @Version: 1.0
 *//*

class StepModelTest_04 {
    public static final Logger logger = LoggerFactory.getLogger(StepModelTest_04.class);

    @BeforeAll
    static void loadTest() throws IOException {
        ApiLoader.load("src/test/resources/api");
        logger.info("debugger");

    }

    @Test
    void getActionTest() {
        //实参
        ArrayList<String> actualParameter = new ArrayList<>();
        actualParameter.add("ww2371688596201076");
        actualParameter.add("okaj3sQZSWJmGneNjh4s4IHkp5RD8j3v_7ZSa8IHF6Y");
        ApiLoader.getAction("tokenhelper", "getToken").run(actualParameter);

        // 断言测试
        ArrayList<AssertModel> asserts = new ArrayList<>();
        AssertModel assertModel = new AssertModel();
        assertModel.setActual("errcode");
        assertModel.setExpect("2");
        assertModel.setMatcher("equalTo");
        assertModel.setReason("getToken错误码校验01");
        asserts.add(assertModel);

        //save
        HashMap<String ,String> save = new HashMap<>();
        save.put("accesstoken","access_token");

        //globalsave
        HashMap<String ,String> globalsave = new HashMap<>();
        globalsave.put("accesstoken","access_token");

        StepModel stepModel = new StepModel();
        stepModel.setApi("tokenhelper");
        stepModel.setAction("getToken");
        stepModel.setActualParameter(actualParameter);
        stepModel.setAsserts(asserts);
        stepModel.setSave(save);
        stepModel.setSaveGlobal(globalsave);

        stepModel.run(null);
        logger.info("debugger");
    }
}*/
