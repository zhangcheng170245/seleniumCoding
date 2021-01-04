package com.apiobject.framework.global;

import com.apiobject.framework.actions.ApiActionModel;
import com.apiobject.framework.api.ApiObjectModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: zhangcheng
 * @Description: 对象加载器
 * @Date: 2020/12/31 14:28
 * @Version: 1.0
 */
public class ApiLoader {

    public static final Logger logger = LoggerFactory.getLogger(ApiLoader.class);

    //加载apiobject 对象，保存到本列表中
    public static ArrayList<ApiObjectModel> objectModels= new ArrayList<>();

    // load方法批量反序列化一个路径下所有的yaml文件
    public static void  load(String dir){
        //使用stream 遍历
        Arrays.stream(new File(dir).list()).forEach(path ->{
            // 遍历文件路径
            try {
                objectModels.add(ApiObjectModel.load(dir+"/"+path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    //根据api名称和action名称 从反序列化的对象列表中获取某个action
    public static ApiActionModel getAction(String apiName, String actionName){
        final ApiActionModel[] apiActionModel = {new ApiActionModel()};
        objectModels.stream()
                .filter(api ->api.getName().equals(apiName)) //筛选是否apiname
                .forEach(api ->{
                    apiActionModel[0] =api.getActions().get(actionName);
                });
            // 判空
            if (apiActionModel[0]!=null){
                return   apiActionModel[0];
            }else {
                logger.info("没有发现接口对象："+apiName+"的action"+actionName);

            }

        return null;
    }




}
