package com.zz.app.core;

import com.zz.app.config.config;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @Author: zhangcheng
 * @Description: app 参数设置 初始化
 * @Date: 2021/3/15/015 15:44
 * @Version: 1.0
 */
public class zzAppset {
    //设置启动app的参数
    private final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

    public DesiredCapabilities initAndroid(){
        setNoReset(true); //
        setPlatformName(config.APP_PLATFORM_NAME);
        setDeviceName(config.DEVICE_NAME);
        setUdid(config.UDID);
        setAppPackage(config.APP_PACKAGE);
        setAppActivity(config.APP_ACTIVITY);
        setAdbExecTimeout(config.APP_ADB_EXEC_TIMEOUT);
        return desiredCapabilities;
    }
    /**
     * 设置平台名称
     * @param platformName android 、 ios
     */
    public void setPlatformName(String platformName){
        desiredCapabilities.setCapability("platformName", platformName);
    }
    /**
     * 设置设备的唯一标识符
     * @param udid 唯一标识符
     */
    public void setUdid(String udid){
        desiredCapabilities.setCapability("udid", udid);
    }

    /**
     * 设置设备名称
     * @param deviceName 设备名称
     */
    public void setDeviceName(String deviceName){
        desiredCapabilities.setCapability("deviceName", deviceName);
    }

    /**
     * 设置程序的包名  android独有
     * @param appPackage	包名
     */
    public void setAppPackage(String appPackage){
        desiredCapabilities.setCapability("appPackage", appPackage);
    }

    /**
     * 设置android的activity
     * @param appActivity activity
     */
    public void setAppActivity(String appActivity){
        desiredCapabilities.setCapability("appActivity", appActivity);
    }

    /**
     * 设置是否保留程序的状态
     * @param noReset	true表示保留，false表示重置
     */
    public void setNoReset(boolean noReset) {
        desiredCapabilities.setCapability("noReset",noReset);
    }



    /**
     * 将键盘置为原始状态
     * @param resetKeyboard  true：置为原始状态  false：保持原样
     */
    public void setResetKeyboard(boolean resetKeyboard) {
        desiredCapabilities.setCapability("resetKeyboard",resetKeyboard);
    }

    /**
     * 设置adb命令执行的超时时间
     * @param timeout	超时时间
     */
    public void setAdbExecTimeout(Long timeout){
        desiredCapabilities.setCapability("adbExecTimeout", timeout);
    }
}