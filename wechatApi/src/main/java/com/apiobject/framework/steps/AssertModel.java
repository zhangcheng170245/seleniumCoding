package com.apiobject.framework.steps;

import io.restassured.response.Response;
import lombok.Data;

/**
 * @Author: zhangcheng
 * @Description: 需要定义的AssertModel类
 * @Date: 2020/12/31 23:01
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
