package com.zz.wx.testcase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.zz.utils.FakerUtils;
import com.zz.wx.steps.StepResult;
import com.zz.wx.steps.zcStepModel;
import lombok.Data;
import org.junit.jupiter.api.function.Executable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertAll;

/*
*
 * @Author: zhangcheng
 * @Description: 用例yaml 对应的数据对象
 * @Date: 2021/3/20/020 21:54
 * @Version: 1.0

*/

@Data
public class ApiTestCaseModel {
    //日志
    public static final Logger logger = LoggerFactory.getLogger(ApiTestCaseModel.class);
    //YAML--------- 对应的参数变量
    private String name;
    private String description;
    private ArrayList<zcStepModel> steps;
    //YAML--------- 对应的参数变量

    //存放断言结果的中间类
    private ArrayList<Executable> assertList = new ArrayList<>();
    private HashMap<String, String> testCaseVariables = new HashMap<>();

/*
*
     * @param path yaml路劲
     * @return

*/

    public static ApiTestCaseModel load(String path) throws IOException {
        //jackson 读取yaml
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        return objectMapper.readValue(new File(path), ApiTestCaseModel.class);
    }

    public void run() {
        // 1 加载用例层 关键字
        this.testCaseVariables.put("getTimeStamp", FakerUtils.getTimeStamp());
        logger.info("用例更新：" + testCaseVariables);

        //2执行step，收集结果
        steps.forEach(step -> {
            StepResult stepResult = step.run(testCaseVariables);
            //2.1  处理save变量 step 不断累计
            if (stepResult.getStepVariables().size() > 0) {
                testCaseVariables.putAll(stepResult.getStepVariables());
                logger.info("testcae变量更新： " + testCaseVariables);
            }
            //2.2 收集assertList
            if (stepResult.getAssertList().size() > 0) {
                assertList.addAll(stepResult.getAssertList());
            }
        });
        //断言
        assertAll("", assertList.stream());
    }
}
