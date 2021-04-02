package com.zz.wx.global;

import java.util.HashMap;

/*
*
 * @Author: zhangcheng
 * @Description: d定义的全局变量
 * @Date: 2021/3/20/020 10:45
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
