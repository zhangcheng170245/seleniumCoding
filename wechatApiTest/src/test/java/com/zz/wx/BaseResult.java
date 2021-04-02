package com.zz.wx;

import io.restassured.response.Response;
import lombok.Data;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/20/020 19:27
 * @Version: 1.0
 */
@Data
public class BaseResult {
    private Response response;
}
