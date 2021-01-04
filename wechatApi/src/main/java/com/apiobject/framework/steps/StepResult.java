package com.apiobject.framework.steps;

import com.apiobject.framework.BaseResult;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: zhangcheng
 * @Description: step执行结果对象
 * @Date: 2020/12/31 23:28
 * @Version: 1.0
 */
public class StepResult  extends BaseResult {
    private ArrayList<Executable> assertList;
    private HashMap<String,String> stepVariables=new HashMap<>();
    public ArrayList<Executable> getAssertList() {
        return assertList;
    }

    public void setAssertList(ArrayList<Executable> assertList) {
        this.assertList = assertList;
    }

    public HashMap<String, String> getStepVariables() {
        return stepVariables;
    }

    public void setStepVariables(HashMap<String, String> stepVariables) {
        this.stepVariables = stepVariables;
    }
}
