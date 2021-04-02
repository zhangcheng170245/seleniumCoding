package com.zz.wx.steps;

import io.restassured.response.Response;
import lombok.Data;

/**
 * @Author: zhangcheng
 * @Description: 断言结果存储对象
 * @Date: 2021/3/20/020 18:33
 * @Version: 1.0
 */

@Data
public class AssertModel {
    private String actual;
    private String matcher;
    private String expect;
    private String reason;

    public void run(Response response){
    }
}
