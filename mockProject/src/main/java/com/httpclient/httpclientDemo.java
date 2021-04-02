package com.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2020/12/15 13:48
 * @Version: 1.0
 */
public class httpclientDemo {

    @Test
    public void httpGet() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://www.baidu.com/");
        System.out.println("executing request " + httpget.getURI());
        //执行请求
        CloseableHttpResponse response = httpclient.execute(httpget);
        // 获取响应实体
        HttpEntity entity = response.getEntity();
        System.out.println("Response content: " + EntityUtils.toString(entity));
    }

}
