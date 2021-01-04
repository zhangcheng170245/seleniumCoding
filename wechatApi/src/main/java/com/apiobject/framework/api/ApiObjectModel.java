package com.apiobject.framework.api;

import com.apiobject.framework.actions.ApiActionModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @Author: zhangcheng
 * @Description: 接口对象类 ==对应tokoenhelp.yml
 * 、反序列化apiobject 为yaml
 * @Date: 2020/12/30 14:44
 * @Version: 1.0
 */
@Data
public class ApiObjectModel {
    private String name;
    private HashMap<String, ApiActionModel> actions; //接口动作对象
    private HashMap<String, String> obVariables= new HashMap<>();

    /**
     *     // load方法反序化一个yaml 为apiObjectModel对象
     * @param path 路径
     * @return
     * @throws IOException
     */
    public static  ApiObjectModel load(String path) throws IOException {
        //加载yaml文件
        ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());
        /**
         * ApiObjectModel 反序列化类 名
         */
        return objectMapper.readValue(new File(path),ApiObjectModel.class);
    }



}
