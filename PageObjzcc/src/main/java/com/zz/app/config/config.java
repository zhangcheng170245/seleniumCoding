package com.zz.app.config;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author: zhangcheng
 * @Description: app参数配置类
 * @Date: 2021/3/15/015 15:16
 * @Version: 1.0
 */
public class config {

    public static String APP_SERVER = null;
    public static String UDID = null;
    public static String DEVICE_NAME = null;
    public static String APP_PACKAGE = null;
    public static String APP_ACTIVITY = null;
    public static String APP_PLATFORM_NAME = null;
    public static Long APP_ADB_EXEC_TIMEOUT = null;
    //从配置文件读取设备信息
    static {
        Properties pro = new Properties();
        //getclassloader取值
        try {
            pro.load(config.class.getClassLoader().getResourceAsStream("config.properties"));
            UDID = pro.getProperty("app.udid");
            DEVICE_NAME = pro.getProperty("app.deviceName");
            APP_PACKAGE = pro.getProperty("app.package");
            APP_ACTIVITY = pro.getProperty("app.activity");
            APP_PLATFORM_NAME = pro.getProperty("app.platformName");
            APP_SERVER = pro.getProperty("app.server");
            APP_ADB_EXEC_TIMEOUT = Long.parseLong(pro.getProperty("app.adb.exec.timeout"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
