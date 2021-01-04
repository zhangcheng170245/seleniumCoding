package com.apiobject.framework.global;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2020/12/31 15:03
 * @Version: 1.0
 */
class ApiLoaderTest {
    public static final Logger logger = LoggerFactory.getLogger(ApiLoaderTest.class);

    //遍历测试
    @BeforeAll
    static void loadTest(){
        ApiLoader.load("src/test/resources/api");
        logger.info("sss!");
    }

    @Test
    void  getActionTest(){
        ArrayList<String> actualParameter = new ArrayList<>();
        actualParameter.add("ww2371688596201076");
        actualParameter.add("okaj3sQZSWJmGneNjh4s4IHkp5RD8j3v_7ZSa8IHF6Y");

        ApiLoader.getAction("tokenhelper","getToken").run(actualParameter);


    }
}