package com.apiobject.framework.api;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author: zhangcheng
 * @Description: 接口对象类c测试
 * @Date: 2020/12/31 10:21
 * @Version: 1.0
 */
class ApiObjectModelTest {

    public static final Logger logger = LoggerFactory.getLogger(ApiObjectModelTest.class);

    @Test
    public void runTest() throws IOException {
        ArrayList<String> actualParameter = new ArrayList<>();
        actualParameter.add("ww2371688596201076");
        actualParameter.add("okaj3sQZSWJmGneNjh4s4IHkp5RD8j3v_7ZSa8IHF6Y");

        ApiObjectModel apiObjectModel= ApiObjectModel.load("src/test/resources/api/tokenhelper.yaml");
        apiObjectModel.getActions().get("getToken").run(actualParameter);
    }


}