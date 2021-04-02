package com.apiobject.framework.steps;

import com.apiobject.framework.global.ApiLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/1/1 22:51
 * @Version: 1.0
 */
class StepModelTest {
    public static final Logger logger = LoggerFactory.getLogger(StepModelTest.class);

    @BeforeAll
    static void loadTest() throws IOException {
        ApiLoader.load("src/main/resources/api");
        logger.info("debugger!");
    }

    @Test
    void runTest() {
        //实参
        ArrayList<String> actualParameter = new ArrayList<>();
        actualParameter.add("ww2371688596201076");
        actualParameter.add("okaj3sQZSWJmGneNjh4s4IHkp5RD8j3v_7ZSa8IHF6Y");

        //模拟yamal文件读取
        ArrayList<AssertModel> asserts = new ArrayList<>();
        AssertModel assertModel = new AssertModel();
        assertModel.setActual("errcode");
        assertModel.setExpect("2");
        assertModel.setMatcher("equalTo");
        assertModel.setReason("getToken错误码校验01");
        asserts.add(assertModel);
        //save b保存测试
        HashMap<String, String> save = new HashMap<>();
        save.put("accesstoken", "access_token");
        //globalsave
        HashMap<String, String> globalsave = new HashMap<>();
        globalsave.put("accesstoken", "access_token");

        StepModel stepModel = new StepModel();
        stepModel.setApi("tokenhelper");
        stepModel.setAction("getToken");
        stepModel.setActualParameter(actualParameter);
        stepModel.setAsserts(asserts);
        //保存
        stepModel.setSave(save);
        stepModel.setSaveGlobal(globalsave);

        stepModel.run(null);
        logger.info("Debugger!");
    }
}