package com.apiobject.framework.testcase;

import com.apiobject.framework.steps.StepModel;
import com.apiobject.framework.steps.StepResult;
import com.apiobject.framework.utils.FakerUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Data;
import org.junit.jupiter.api.function.Executable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * @Author: zhangcheng
 * @Description: 用例yaml对应的数据对象
 * @Date: 2021/1/2 15:54
 * @Version: 1.0
 */
@Data
public class ApiTestCaseModel {

    public static final Logger logger = LoggerFactory.getLogger(ApiTestCaseModel.class);

    private String name;
    private String description;
    private ArrayList<StepModel> steps;
    private ArrayList<Executable> arrestList= new ArrayList<>();
    private HashMap<String,String> testCaseVariables= new HashMap<>();

    public static ApiTestCaseModel load(String path) throws IOException {
        //加载yaml文件
        ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());
        /**
         * ApiObjectModel 反序列化类 名
         */
        return objectMapper.readValue(new File(path),ApiTestCaseModel.class);
    }

    public void run() {
        //1 加载用例层的关键字变量
        this.testCaseVariables.put("getTimeStamp", FakerUtils.getTimeStamp());
        logger.info("用例变量更新:" + testCaseVariables);
        //2 遍历step执行
        steps.forEach(step -> {
            StepResult stepResult = step.run(testCaseVariables);
            //3 保存变量
            if (stepResult.getStepVariables().size() > 0) {
                testCaseVariables.putAll(stepResult.getStepVariables());
                logger.info("testcase用例变量更新:" + testCaseVariables);
            }
            //4 处理assertList 统一断言
            if (stepResult.getAssertList().size() > 0) {
                arrestList.addAll(stepResult.getAssertList());
                logger.info(":" + testCaseVariables);
            }
        });
        //统一断言
        assertAll("", arrestList.stream());
    }
}
