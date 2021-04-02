package com.zz.wx.steps;

import com.zz.utils.PlaceholderUtils;
import com.zz.wx.global.GlobalVariables;
import com.zz.wx.global.zcApiLoader;
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

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/25/025 15:52
 * @Version: 1.0
 */
@Data
public class zcStepModel {
    public static final Logger logger = LoggerFactory.getLogger(zcStepModel.class);

    //1、需要定义AssertModel类，用来存储反序列化出来的断言对象
    private  String api;
    private String action;
    private ArrayList<String> actualParameter;
    private ArrayList<AssertModel> asserts; // 断言结果
    private HashMap<String, String> saveGlobal;
    private HashMap<String, String> save;

    //3、替换实参中的变量  TODO
    private ArrayList<String> finalActualParameter = new ArrayList<>();//最终的实参
    private HashMap<String, String> stepVariables = new HashMap<>();//存储action中返回的结果,用于其他参数值
    private ArrayList<Executable> assertList = new ArrayList<>();  //存储每一步的断言结果

    private StepResult stepResult = new StepResult();

    //执行用例
    public StepResult run(HashMap<String,String> testCaseVariables){
        if (actualParameter!=null){
            //替换实参中的变量,
            finalActualParameter= PlaceholderUtils.resolveList(actualParameter,testCaseVariables);
        }
        // TODO 4、 调用apiloader 获取 根据case中的配置执行相应的action，当然要传入替换过变量的实参
        Response response = zcApiLoader.getAction(api, action).run(finalActualParameter);

        // TODO 5、根据case中的配置截取响应中的字段，并存入step变量Map中
        if (save != null && save.size() > 0) {
            save.forEach((variablesName, path) -> {
                String value = response.path(path).toString(); // 获取存储的值
                stepVariables.put(variablesName, value);
                logger.info("step变量更新： " + variablesName + "=" + value);
            });
        }
        //TODO 6、根据case中的配置截取响应中的字段，并存入Global变量Map中
        if (saveGlobal != null) {
            saveGlobal.forEach((variablesName, path) -> {
                String value = response.path(path).toString();
                GlobalVariables.getGlobalVariables().put(variablesName, value);
                logger.info("全局变量更新： " + variablesName + "=" + value);
            });
        }


        //TODO 7、根据case中的配置对返回结果进行软断言，但不会终结测试将断言结果存入断言结果列表中，在用例最后进行统一结果输
        if (asserts!=null){
            asserts.forEach(assertModel -> {
                assertList.add(()->{
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