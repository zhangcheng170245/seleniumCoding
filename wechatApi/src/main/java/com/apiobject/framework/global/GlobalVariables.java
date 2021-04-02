package com.apiobject.framework.global;

import java.util.HashMap;

/**
 * @Author: zhangcheng
 * @Description: 存储全局变量
 * @Date: 2020/12/26 23:28
 * @Version: 1.0
 */
public class GlobalVariables {
    static private HashMap<String, String> globalVariables = new HashMap<>();

    public static HashMap<String, String> getGlobalVariables() {
        return globalVariables;
    }

    public static void setGlobalVariables(HashMap<String, String> globalVariables) {
        GlobalVariables.globalVariables = globalVariables;
    }
}
