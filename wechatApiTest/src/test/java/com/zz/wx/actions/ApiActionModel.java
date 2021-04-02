/*
package com.zz.wx.actions;

import com.zz.utils.PlaceholderUtils;
import com.zz.wx.global.GlobalVariables;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
*/
/*
*
 * @Author: zhangcheng
 * @Description: 接口动作对象  存储接口对象yaml反序列化出来的action单元
 * @Date: 2021/3/19/019 11:26
 * @Version: 1.0

*//*


@Data
public class ApiActionModel {
    private String method = "get";
    private String url;
    private String body;
    private String contentType;
    private HashMap<String, String> query; // 查询参数
    private HashMap<String, String> headers; //请求头
    private String post; // 简便的方法
    private String get;
    private Response response; //接受返回参数
    private ArrayList<String> formalParam; //形参
    private HashMap<String, String> actionVariables = new HashMap<>();

    //run方法
    public Response run(ArrayList<String> actualParameter) {
        //存放 读取yaml后数据
        HashMap<String, String> finalQuery = new HashMap<>();
        String runBody = this.body; //body全局变量
        String runUrl = this.url; //url全局变量
        //1 确定请求方法url
        if (post != null) {
            runUrl = post; //runurl 为post字段后的 地址值
            method = "post";
        } else if (get != null) {
            runUrl = get;
            method = "get";
        }
        //2 确定请求参数  URL 中全局变量替换 使用占位符工具
        if (query != null) {
            //替换后的数据存储到 全局变量
            // 存储到全局变量中
            finalQuery.putAll(PlaceholderUtils.resolveMap(query,
                    GlobalVariables.getGlobalVariables()));
        }
        // body全局变量替换
        runBody = PlaceholderUtils.resolveString(runBody,
         GlobalVariables.getGlobalVariables());
        // url全局变量替换
        runUrl = PlaceholderUtils.resolveString(runUrl,
         GlobalVariables.getGlobalVariables());
        // 判断形参
        if (formalParam != null && actualParameter != null &&
                formalParam.size() > 0 && actualParameter.size() > 0) {
            //3据形参实参构建内部变量MAP
            for (int index=0; index<formalParam.size();index++){
                actionVariables.put(formalParam.get(index), actualParameter.get(index));
            }
        // 4 请形参赋值
            if (query!=null){
                finalQuery.putAll(PlaceholderUtils.resolveMap(query,actionVariables));
            }
            runBody = PlaceholderUtils.resolveString(body,actionVariables);
            runUrl = PlaceholderUtils.resolveString(runUrl,actionVariables);
         }
        //5 拿到已经完成变量替换的数据 进行請求并返回結果
        RequestSpecification requestSpecification = given().log().all();
        //判断类型
        if (contentType != null) {
            requestSpecification.contentType(contentType);
        }
        if (headers != null) {
            requestSpecification.headers(headers);
        }
        if (finalQuery != null && finalQuery.size() > 0) {
            requestSpecification.formParams(finalQuery);
        } else if (runBody != null) {
            requestSpecification.body(runBody);
        }
        // 使用 组装完成的方法请求
        Response response = requestSpecification.request(method, runUrl)
                .then().log().all().extract().response();
        this.response = response;

        return response;



    }






}
*/
