package com.apiobject.framework.testcase;

import com.apiobject.framework.global.ApiLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/1/2 17:37
 * @Version: 1.0
 */
class ApiTestCaseModelTest {
    public static final Logger logger = LoggerFactory.getLogger(ApiTestCaseModelTest.class);

    @BeforeAll
    static void loadTest() throws IOException {
        ApiLoader.load("src/test/resources/api");
        logger.info("debugger!");
    }
    @Test
    void loadApiTest() throws IOException {
        ApiTestCaseModel apiTestCaseModel = ApiTestCaseModel.load("src/test/resources/testcase/creatdepartment.yaml");
        logger.info("Debugger!");


    }

    @Test
    void runTest() throws IOException {
        ApiTestCaseModel apiTestCaseModel = ApiTestCaseModel.load("src/test/resources/testcase/creatdepartment.yaml");
        apiTestCaseModel.run();
        logger.info("Debugger!");

    }



}