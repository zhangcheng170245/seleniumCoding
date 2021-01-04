package com.apiobject.framework.steps;

import com.apiobject.framework.global.ApiLoader;
import com.apiobject.framework.global.GlobalVariables;
import com.apiobject.framework.utils.PlaceholderUtils;
import io.restassured.response.Response;
import lombok.Data;
import org.junit.jupiter.api.function.Executable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @Author: zhangcheng
 * @Description: 用例中的步骤 对象
 * @Date: 2020/12/31 23:00
 * @Version: 1.0
 */
@Data
public class StepModel {
    public static final Logger logger = LoggerFactory.getLogger(StepModel.class);

    //需要定义的AssertModel类
    private String api;
    private String action;
    private ArrayList<String> actualParameter; //实参
    private ArrayList<AssertModel> asserts; // 断言
    private HashMap<String, String> save;
    private HashMap<String, String> saveGlobal;

    //定义局部变量
    private  ArrayList<String> finalActualParameter=new ArrayList<>();
    private HashMap<String, String> stepVariables=new HashMap<>();
    //结果存储对象
    private StepResult stepResult= new StepResult();
    //断言列表存储对象
    private ArrayList<Executable> assertList=new ArrayList<>();

    //testCaseVariables--储存每一个step返回的变量
    public  StepResult run(HashMap<String,String> testCaseVariables){
        //非空判断
        if (actualParameter!=null){
            finalActualParameter.addAll(PlaceholderUtils.resolveList(actualParameter,testCaseVariables));
        }
        //  * 4、根据case中配置的API对象和action信息，取出并执行相应的action
        Response response=ApiLoader.getAction(api,action).run(finalActualParameter);
        //5 保存
        if (save!= null){
            save.forEach((variablesName, path)->{ //变量名，jsonpath
               String value= response.path(path).toString();
               stepVariables.put(variablesName,value);
               logger.info("step 变量更新："+stepVariables);
            });
        }
        if (saveGlobal!= null){
            saveGlobal.forEach((variablesName, path)->{ //变量名，jsonpath
                String value= response.path(path.toString());
                GlobalVariables.getGlobalVariables().put(variablesName,value);
                logger.info("全局变量更新： " + GlobalVariables.getGlobalVariables());
            });
        }
        //断言
        if (asserts !=null){
            asserts.stream().forEach(assertModel -> {
                assertList.add(() -> {
                    // 预想值，实际结果
                    assertThat(assertModel.getReason(),
                            response.path(assertModel.getActual()).toString(),
                            equalTo(assertModel.getExpect()));
                });
            });
        }
        //
        stepResult.setAssertList(assertList);
        stepResult.setStepVariables(stepVariables);
        stepResult.setResponse(response);

        return  stepResult;

    }


}
