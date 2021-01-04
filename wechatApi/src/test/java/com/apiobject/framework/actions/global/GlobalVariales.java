package com.apiobject.framework.actions.global;

import java.util.HashMap;

/**
 * @Author: zhangcheng
 * @Description: 存储全局变量
 * @Date: 2020/12/26 23:28
 * @Version: 1.0
*/

public class GlobalVariales {
    static private HashMap<String, String> globalVariales= new HashMap<>();

    public static void setGlobalVariales(HashMap<String, String> globalVariales) {
        GlobalVariales.globalVariales = globalVariales;
    }

    public static HashMap<String, String> getGlobalVariales() {
        return globalVariales;
    }
}
