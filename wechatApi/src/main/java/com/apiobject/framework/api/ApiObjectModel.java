package com.apiobject.framework.api;

import com.apiobject.framework.actions.ApiActionModel;
import lombok.Data;

import java.util.HashMap;

/**
 * @Author: zhangcheng
 * @Description: 接口对象类 ==对应tokoenhelp.yml
 * @Date: 2020/12/30 14:44
 * @Version: 1.0
 */
@Data
public class ApiObjectModel {
    private String name;
    private HashMap<String, ApiActionModel> actions; //接口动作对象
    private HashMap<String, String> obVariables= new HashMap<>();

    public static  ApiObjectModel load(String path){
        return null;

    }







}
