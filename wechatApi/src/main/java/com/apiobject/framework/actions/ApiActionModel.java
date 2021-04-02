package com.apiobject.framework.actions;

import com.apiobject.framework.global.GlobalVariables;
import com.apiobject.framework.utils.PlaceholderUtils;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * @Author: zhangcheng
 * @Description: 接口动作对象
 * @Date: 2020/12/26 22:26
 * @Version: 1.0
 */
@Data
public class ApiActionModel {
    private String method = "get"; //设置默认请求方式为get
    private String url;
    private String body;
    private String contentType;
    private HashMap<String, String> query; //查询参数
    private HashMap<String, String> headers; //请求头
    private String post;
    private String get;
    private Response response; //接受返回参数
    private ArrayList<String> formalParam; //形参
    private HashMap<String, String> actionVariables = new HashMap<>();

    //定义run方法
    public Response run(ArrayList<String> actualParameter) {  //入参
        // 存  转移后的数据
        HashMap<String, String> finalQuery = new HashMap<>();
        //方法级别的变量
        String runBody = this.body;
        String runUrl = this.url;
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
            // 存储到全局变量中
            finalQuery.putAll(PlaceholderUtils.resolveMap(query,
                    GlobalVariables.getGlobalVariables()));
        }
        // 替换body全局变量
        runBody = PlaceholderUtils.resolveString(runBody, GlobalVariables.getGlobalVariables());
        //替换url全局变量
        runUrl = PlaceholderUtils.resolveString(runUrl, GlobalVariables.getGlobalVariables());

        if (formalParam != null && actualParameter != null &&
                formalParam.size() > 0 && actualParameter.size() > 0) {
            //3据形参实参构建内部变量MAP
            for (int index = 0; index < formalParam.size(); index++) {
                //实参放入转换的值
                actionVariables.put(formalParam.get(index), actualParameter.get(index));
            }
            //4 请求url 内部变量进行替换
            if (query != null) {
                finalQuery.putAll(PlaceholderUtils.resolveMap(query, actionVariables));
            }
            runBody = PlaceholderUtils.resolveString(body, actionVariables);
            runUrl = PlaceholderUtils.resolveString(runUrl, actionVariables);
        }
        //5 請求返回結果
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