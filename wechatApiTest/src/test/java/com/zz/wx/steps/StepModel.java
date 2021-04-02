/*
package com.zz.wx.steps;

import com.zz.utils.PlaceholderUtils;
import com.zz.wx.global.ApiLoader;
import com.zz.wx.global.GlobalVariables;
import io.restassured.response.Response;
import lombok.Data;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.function.Executable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertThat;

*/
/**
 * @Author: zhangcheng
 * @Description: 用例中的step对象
 * @Date: 2021/3/20/020 18:27
 * @Version: 1.0
 *//*

@Data
public class StepModel {
    public static final Logger logger = LoggerFactory.getLogger(StepModel.class);
    // 存储yaml文件  对应yaml 结构
    private String api;
    private String action;
    private ArrayList<String> actualParameter;
    private ArrayList<AssertModel> asserts; // 断言结果
    private HashMap<String, String> save;
    private HashMap<String, String> saveGlobal;


    private ArrayList<String> finalActualParameter = new ArrayList<>();//最终的实参
    private HashMap<String, String> stepVariables = new HashMap<>();//存储action中返回的结果,用于其他参数值
    private ArrayList<Executable> assertList = new ArrayList<>();  //存储每一步的断言结果

    private StepResult stepResult = new StepResult();

    */
/**
     * @param testCaseVariables 测试用例使用的变量
     * @return
     *//*

    public StepResult run(HashMap<String, String> testCaseVariables) {
        if (actualParameter != null) { //实参
            finalActualParameter = PlaceholderUtils.resolveList(actualParameter, testCaseVariables);
        }
        //1 获取对应的api和action执行
        Response response = ApiLoader.getAction(api, action).run(finalActualParameter);

        //存储save 中 的内容
        if (save != null && save.size() > 0) {
            save.forEach((variablesName, path) -> {
                String value = response.path(path).toString(); // 获取存储的值
                stepVariables.put(variablesName, value);
                logger.info("step变量更新： " + variablesName + "=" + value);

            });
        }

        //软断言需要的中间断言，不会终结测试将断言结果存入断言结果列表中，在用例最后进行统一结果输出
        if (asserts != null) {
            asserts.forEach(assertModel -> {  //遍历
                assertList.add(() -> {         //  遍历存储到assertlist中
                    String reason = assertModel.getReason();
                    String actualPath = assertModel.getActual().toString();
                    String matcher = assertModel.getMatcher();
                    String expect = assertModel.getExpect();
                    //反射获取  hamcrest需要断言的方式
                    Class<Matchers> aClass = (Class<Matchers>) Class.forName("org.hamcrest.Matchers");
                    Method method = aClass.getDeclaredMethod(matcher, Object.class);
                    Matcher invoke = (Matcher) method.invoke(aClass.newInstance(), expect);

                    assertThat(reason, response.path(actualPath), invoke);
                });
            });
        }
        //组装response和断言结果返回
        stepResult.setAssertList(assertList);
        stepResult.setStepVariables(stepVariables);
        stepResult.setResponse(response);
        return stepResult;
    }

}
*/
