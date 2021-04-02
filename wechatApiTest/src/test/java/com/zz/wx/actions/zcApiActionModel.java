package com.zz.wx.actions;

import com.zz.utils.PlaceholderUtils;
import com.zz.wx.global.GlobalVariables;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * @Author: zhangcheng
 * @Description: 接口动作对象 对应 har目录下的 tokenhelp.yaml（从charses导出har文件）
 * 反序列化为action 对象
 * @Date: 2021/3/24/024 19:31
 * @Version: 1.0
 */
@Data
public class zcApiActionModel {
    private String method="get";
    private String url;
    private String body;
    private String contentType;
    private HashMap<String,String> query;
    private HashMap<String,String> headers;
    private String get;
    private String post;
    private Response response;
    private ArrayList<String> formalParam; //形参
    private HashMap<String,String> actionVariables=new HashMap<>(); //

    /**
     * @param actualParameter 传入的实际参数
     * @return
     */
    public Response run( ArrayList<String> actualParameter) {
        //存放 读取yaml后变量
        HashMap<String, String> finalQuery = new HashMap<>();
        String runBody = this.body; //body全局变量
        String runUrl = this.url; //url全局变量
        //1 确定请求方法和url
        if (post != null) {
            runUrl = post;
            method = "post";
        } else if (get != null) {
            runUrl = get;
            method = "get";
        }
        //2 确定请求参数  URL 字符串工具类替换 url body 全局变量替换
        if (query != null) { // 替换符更换后存到全局变量
            finalQuery.putAll(PlaceholderUtils.resolveMap(query,
                    GlobalVariables.getGlobalVariables()));
        }
        runBody = PlaceholderUtils.resolveString(runBody, GlobalVariables.getGlobalVariables());
        runUrl = PlaceholderUtils.resolveString(runUrl, GlobalVariables.getGlobalVariables());
        //形参实参非空判断
        if (formalParam != null && actualParameter != null &&
                formalParam.size() > 0 && actualParameter.size() > 0) {
        //3根据形参实参构建内部变量MAP 遍历
            for (int index = 0; index < formalParam.size(); index++) { // 实参和形参组装成请求参数 类似于 action: getToken
                actionVariables.put(formalParam.get(index), actualParameter.get(index));
            }
            // 4 实参赋值
            if (query != null) {
                finalQuery.putAll(PlaceholderUtils.resolveMap(query, actionVariables));
            }
            runBody = PlaceholderUtils.resolveString(body, actionVariables);
            runUrl = PlaceholderUtils.resolveString(runUrl, actionVariables);
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
        Response response = requestSpecification.request(method, runUrl).then().log().all().extract().response();
        this.response = response;
        return response;


    }
    }