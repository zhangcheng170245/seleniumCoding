package com.zz.wx.steps;

import com.zz.wx.BaseResult;
import lombok.Data;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: zhangcheng
 * @Description: STEP 执行结果对象  Executable断言的中间结果
 * @Date: 2021/3/20/020 19:26
 * @Version: 1.0
 */

@Data
public class StepResult  extends BaseResult {
    private ArrayList<Executable> assertList;
    private HashMap<String,String> stepVariables = new HashMap<>();
}
