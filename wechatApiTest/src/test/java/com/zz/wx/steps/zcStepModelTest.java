package com.zz.wx.steps;

import com.zz.wx.global.zcApiLoader;
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
 * @Date: 2021/3/25/025 16:49
 * @Version: 1.0
 */
class zcStepModelTest {
    public static final Logger logger = LoggerFactory.getLogger(zcStepModelTest.class);

    @BeforeAll
    static void loadTest() throws IOException {
        zcApiLoader.load("src/test/resources/api");
        logger.info("debugger");
    }

    @Test
    void run() {
        //实参
        ArrayList<String> actualParameter = new ArrayList<>();
        actualParameter.add("ww2371688596201076");
        actualParameter.add("okaj3sQZSWJmGneNjh4s4IHkp5RD8j3v_7ZSa8IHF6Y");
        zcApiLoader.getAction("tokenhelper", "getToken").run(actualParameter);


        //断言
        ArrayList<AssertModel> asserts = new ArrayList<>();
        AssertModel assertModel = new AssertModel();
        assertModel.setActual("errcode");
        assertModel.setExpect("2");
        assertModel.setMatcher("equalTo");
        assertModel.setReason("getToken错误码校验01");
        //
        asserts.add(assertModel);

        //save
        HashMap<String ,String> save = new HashMap<>();
        save.put("accesstoken","access_token");

        //globalsave
        HashMap<String ,String> globalsave = new HashMap<>();
        globalsave.put("accesstoken","access_token");

        zcStepModel  stepModel = new zcStepModel();
        stepModel.setApi("tokenhelper");
        stepModel.setAction("getToken");
        stepModel.setActualParameter(actualParameter);
        stepModel.setAsserts(asserts);
        stepModel.setSave(save);
        stepModel.setSaveGlobal(globalsave);

        stepModel.run(null);
        logger.info("dd");
    }
}