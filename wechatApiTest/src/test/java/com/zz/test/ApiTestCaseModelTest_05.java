package com.zz.test;

import com.zz.wx.global.zcApiLoader;
import com.zz.wx.testcase.ApiTestCaseModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/*
*
 * @Author: zhangcheng
 * @Description: 对ApiAction对象实现的单元测试
 * @Date: 2021/3/21/021 12:19
 * @Version: 1.0

*/

class ApiTestCaseModelTest_05 {
    public static final Logger logger = LoggerFactory.getLogger(ApiTestCaseModelTest_05.class);

    @BeforeAll
    static void loadTest() throws IOException {
        zcApiLoader.load("src/test/resources/api");
        logger.info("debugger");

    }

    @Test
    void  loadApiTest() throws IOException {
        // 加载测试用例
        ApiTestCaseModel apiTestCaseModel = ApiTestCaseModel.load("src/test/resources/testcase/creatdepartment.yaml");
        logger.info("Debugger!");
    }

    @Test
    void runTest() throws IOException {
        ApiTestCaseModel apiTestCaseModel =  ApiTestCaseModel.load("src/test/resources/testcase/creatdepartment.yaml");
        apiTestCaseModel.run();
        logger.info("Debugger!");

    }

}
