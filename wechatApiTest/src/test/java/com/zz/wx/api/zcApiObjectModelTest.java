package com.zz.wx.api;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/25/025 10:54
 * @Version: 1.0
 */
class zcApiObjectModelTest {
    public static final Logger logger = LoggerFactory.getLogger(zcApiObjectModelTest.class);

    @Test
    void loadTest() throws IOException {
        ArrayList<String> actualParameter = new ArrayList<>();
        actualParameter.add("ww2371688596201076");
        actualParameter.add("okaj3sQZSWJmGneNjh4s4IHkp5RD8j3v_7ZSa8IHF6Y");
        zcApiObjectModel apiObjectModel = zcApiObjectModel  //读取yaml
                .load("src/test/resources/api/tokenhelper.yaml");
        apiObjectModel.getActions().get("getToken").run(actualParameter);
    }

}