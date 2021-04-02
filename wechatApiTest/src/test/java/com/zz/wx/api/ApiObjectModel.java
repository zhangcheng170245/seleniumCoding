/*
package com.zz.wx.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.zz.wx.actions.ApiActionModel;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

*/
/**
 * @Author: zhangcheng
 * @Description: 接口对象类
 * @Date: 2021/3/20/020 11:58
 * @Version: 1.0
 *//*

@Data
public class ApiObjectModel {
    private  String name;
    private HashMap<String, ApiActionModel> actions;
    private HashMap<String ,String> obVariables = new HashMap<>();

    // load方法反序化一个yaml 为apiObjectModel对象
    public  static  ApiObjectModel  load(String path) throws IOException {
        //TODO 加载yaml文件
        ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());
        //TODO 反序列化类名
        return objectMapper.readValue(new File(path),ApiObjectModel.class);

    }
}
*/
