package com.apiobject.framework;

import io.restassured.response.Response;
import lombok.Data;

/**
 * @Author: zhangcheng
 * @Description: 保存对象的基类
 * @Date: 2021/1/1 22:47
 * @Version: 1.0
 */
@Data
public class BaseResult {
    private Response response;
}
