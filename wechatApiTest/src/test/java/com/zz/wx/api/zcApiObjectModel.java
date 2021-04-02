package com.zz.wx.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.zz.wx.actions.zcApiActionModel;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @Author: zhangcheng
 * @Description: 接口对象类
 * @Date: 2021/3/25/025 10:13
 * @Version: 1.0
 */
@Data
public class zcApiObjectModel {
    private String name;
    //存储到apiaction
    private HashMap<String, zcApiActionModel> actions;
    // 变量存储
    private HashMap<String ,String> obVariables = new HashMap<>();

    //定义加载方法 load方法反序化一个yaml 为apiObjectModel对象 api下：
    public static zcApiObjectModel load(String path) throws IOException {
        // jackson 加载yaml文件
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        //  反序列化成类的名字
        return  objectMapper.readValue(new File(path),zcApiObjectModel.class);
    }

}
