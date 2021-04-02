package com.zz.wx.global;

import com.zz.wx.actions.zcApiActionModel;
import com.zz.wx.api.zcApiObjectModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhangcheng
 * @Description: 接口对象加载
 * @Date: 2021/3/25/025 14:04
 * @Version: 1.0
 */
public class zcApiLoader {
    //日志
    public static final Logger logger = LoggerFactory.getLogger(zcApiLoader.class);

    //加载所有的api object 对象，保存在列表中
    private static List<zcApiObjectModel>  apis= new ArrayList<>();

    /**
     * api所在路径
     * @param dir load加载api接口所在位置，使用foreach遍历
     */
    public static  void load(String dir){
        Arrays.stream(new File(dir).list()).forEach(path->{
            try {
                    apis.add(zcApiObjectModel.load(dir+"/"+path)); //遍历文件路径
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     *
     * @param apiName 接口名
     * @param actionName 接口参数名
     * @return
     */
    public static zcApiActionModel getAction(String apiName,String actionName){
        final zcApiActionModel[] apiActionModel = {new zcApiActionModel()};
        apis.stream().filter(apis -> apis.getName().equals(apiName))// 过滤apiname 遍历获取对应接口
            .forEach(apis->{ apiActionModel[0] =apis.getActions().get(actionName); }); //获取接口参数名
        //判空
        if(apiActionModel[0]!=null){
            return apiActionModel[0];
        }else{
            logger.info("没有找到接口对象： "+apiName+"中的action: "+actionName);
        }
        return null;
    }

}
