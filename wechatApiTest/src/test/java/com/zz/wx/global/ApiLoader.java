/*
package com.zz.wx.global;

import com.zz.wx.actions.ApiActionModel;
import com.zz.wx.api.ApiObjectModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

*/
/**
 * @Author: zhangcheng
 * @Description: 接口对象加载器
 * @Date: 2021/3/20/020 12:38
 * @Version: 1.0
 *//*

public class ApiLoader {
    public static final Logger logger = LoggerFactory.getLogger(ApiLoader.class);


    //加载所有对象 ，并保存到本列表中
    private static List<ApiObjectModel>  apiObjectModel= new ArrayList<>();

    public static  void load(String dir){
        Arrays.stream(new File(dir).list()).forEach(path-> {
            try {
                apiObjectModel.add(ApiObjectModel.load(dir + "/" + path));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    */
/**+
     *
     * @param apiName 接口名
     * @param actionName 接口参数名
     *//*

    public static  ApiActionModel  getAction(String apiName,String actionName){
        final ApiActionModel[] apiActionModel = new ApiActionModel[1];
        apiObjectModel.stream().filter(api-> api.getName().equals(apiName)) // 遍历接口名
                .forEach(api ->{//过滤后的apiname
                    apiActionModel[0] =api.getActions().get(actionName);
                });
        //判空
        if(apiActionModel[0]!=null){
            return apiActionModel[0];
        }else{
            logger.info("没有找到接口对象： "+apiName+"中的action: "+actionName);
        }
        return null;
    }

}
*/
