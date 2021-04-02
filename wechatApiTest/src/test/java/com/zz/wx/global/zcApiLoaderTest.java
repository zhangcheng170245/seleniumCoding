package com.zz.wx.global;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/25/025 15:03
 * @Version: 1.0
 */
class zcApiLoaderTest {
    public static final Logger logger = LoggerFactory.getLogger(zcApiLoaderTest.class);

    @BeforeAll
    static void load() {
    //测试加载路径 为
        zcApiLoader.load("src/test/resources/api");
        logger.info("debugger");
    }

    @Test
    void getAction() {
        ArrayList<String> actualParameter = new ArrayList<>();
        actualParameter.add("ww2371688596201076");
        actualParameter.add("okaj3sQZSWJmGneNjh4s4IHkp5RD8j3v_7ZSa8IHF6Y");
        zcApiLoader.getAction("tokenhelper","getToken").run(actualParameter);
    }
}