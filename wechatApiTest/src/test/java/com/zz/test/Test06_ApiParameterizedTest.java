package com.zz.test;

import com.zz.wx.global.zcApiLoader;
import com.zz.wx.testcase.ApiTestCaseModel;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/25/025 19:54
 * @Version: 1.0
 */
public class Test06_ApiParameterizedTest {
    public static final Logger logger = LoggerFactory.getLogger(Test06_ApiParameterizedTest.class);

    /***
     *
     * @param testCaseModel 测试用例
     * @param name
     * @param description
     */
    @ParameterizedTest
    @MethodSource
    void apiTest(ApiTestCaseModel testCaseModel,String name,String description){
        logger.info("【用例开始执行】");
        logger.info("用例名称： " + name);
        logger.info("用例描述： " + description);
        testCaseModel.run();
    }

    static List<Arguments> apiTest(){
        zcApiLoader.load("src/test/resources/api");
        // 传递给参数化用例
        List<Arguments> testcases=new ArrayList<>();
        //读取所有的用例
        String testCaseDir= "src/test/resources/testcase";
        //遍历
        Arrays.stream(new File(testCaseDir).list())
                .forEach(caseName ->{
                    String path= testCaseDir+"/"+caseName;
                    try {
                    ApiTestCaseModel apiTestCase=ApiTestCaseModel.load(path);
                        testcases.add(arguments(apiTestCase, apiTestCase.getName(), apiTestCase.getDescription()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

    return testcases;

    }
}
