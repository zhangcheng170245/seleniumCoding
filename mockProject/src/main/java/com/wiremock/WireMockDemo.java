package com.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.google.gson.stream.JsonReader;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

/**
 * @Author: zhangcheng
 * @Description: WireMock范例
 * @Date: 2020/12/10 21:26
 * @Version: 1.0
 */
public class WireMockDemo {
    @BeforeAll
    public  static void initData(){
        // 实例化wiremock服务
        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8089)); //No-args constructor will start on port 8080, no HTTPS
        wireMockServer.start();
        //指定ip端口
        configureFor("localhost",8089);
    }

    // stub 返回固定值 不够灵活
    @Test
    public void stubMock() {
        try {
            stubFor(get(urlEqualTo("/my/resource"))
                    .withHeader("Accept", equalTo("text/xml"))
                    .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "text/xml")
                            .withBody("<response>iam iconman</response>")));
            Thread.sleep(500000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 伪造restful 服务   "headers":{
    @Test
    void  mockJson(){
        try {
            stubFor(get(urlEqualTo("/login1"))
             .willReturn(WireMock.aResponse()
                .withHeader("Content-Type","text/html;charset=utf-8")       //设置编码
            // .withBody("{\"username\":chengzi}")
              .withBody("{\n" +
                      "\t\"respDesc\": \"成功\",\n" +
                      "\t\"rookieUser\": \"0\",\n" +
                      "\t\"lstSuccLogDttm\": \"20180903092900\",\n" +
                      "\t\"tokenId\": \"3d1883ab77e54e5bb258c1474b1a8687\",\n" +
                      "\t\"isLegal\": \"1\",\n" +
                      "\t\"sessionExpireTime\": \"1800\",\n" +
                      "\t\"idNo\": \"#0110mObBbZWEsw2oiIj+/uOdOJI0kgQ5/L6\",\n" +
                      "\t\"idNoMask\": \"3213**********2574\",\n" +
                      "\t\"userId\": \"3100046000091662\",\n" +
                      "\t\"legalName\": \"CHRX/NwScWE=\",\n" +
                      "\t\"isAgree\": \"1\",\n" +
                      "\t\"shareSessionId\": \"7be02500201ac616c6a39d79db3c44be\",\n" +
                      "\t\"userType\": \"10\",\n" +
                      "\t\"isRealName\": \"1\",\n" +
                      "\t\"respCode\": \"000\"\n" +
                      "}")
              .withStatus(200)
                     .withFixedDelay(20000)));// 延迟

            Thread.sleep(500000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 模拟从本地读取
    @Test
    void mockForlocal(){
        JsonReader jsonReaderStream = new JsonReader(new
                InputStreamReader(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResourceAsStream("success.json"))));
        System.out.println(jsonReaderStream.getPath());

 /*       try {
            stubFor(get(urlEqualTo("/login"))
                    .willReturn(WireMock.aResponse()
                            .withHeader("Content-Type","text/html;charset=utf-8")       //设置编码
                            // .withBody("{\"username\":chengzi}")
                            .withBody(String.valueOf(WireMockDemo.class.getResource("/success.json")))
                            .withStatus(200)
                            .withFixedDelay(20000)));// 延迟

            Thread.sleep(500000);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }



    @Test
    public void delapyDemo(){
        stubFor(get(urlEqualTo("/delayDemo"))
                .willReturn(WireMock.aResponse()
                        .withHeader("Content-Type","text/html;charset=utf-8")
                        .withStatus(HttpStatus.SC_OK) // 设置返回码为200
                        .withBody("ok")
                        .withFixedDelay(20000)));// 延迟
    }

    // 模拟故障码
    @Test
    public void testBadResponse() throws InterruptedException {
            stubFor(get(urlEqualTo("/test"))
           // .willReturn(aResponse().withFault(Fault.EMPTY_RESPONSE))
                    //.willReturn(aResponse().withFault(Fault.CONNECTION_RESET_BY_PEER))
                    .willReturn(aResponse()
                            .withStatus(HttpStatus.SC_SERVICE_UNAVAILABLE)
                            .withHeader("Content-Type", "text/xml")
                            .withBody("service unavailable")));
        Thread.sleep(50000);
    }


    //================================================================================
    @Test   //设置返回切换值
    public void easyMock() {
        try {
            stubFor(get(urlEqualTo("/my/resource"))
                    .withHeader("Accept", equalTo("text/xml"))
                    .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "text/xml")
                            .withBody("<response>one piece</response>")));
            Thread.sleep(50000);
            reset(); // 重置
            stubFor(get(urlEqualTo("/my/resource"))
                    .withHeader("Accept", equalTo("text/xml"))
                    .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "text/xml")
                            .withBody("<response>two piece</response>")));
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test   //代理mock
    public void prpxyMock() {
        System.out.println(WireMockDemo.class.getResource("/mock3.json").getPath());
        try {
            stubFor(get(urlMatching(".*")).atPriority(10)
                    .willReturn(aResponse().proxiedFrom("https://ceshiren.com"))); //监听网站地址的内容
            stubFor(get(urlMatching("/categories_and_latest")).atPriority(10)
                    .willReturn(aResponse().withBody(Files.readAllBytes(
                            // 将返回的内容替换为本地mock后的数据
                            Paths.get(WireMockDemo.class.getResource("/mock3.json").getPath().substring(1)))))); //读取修改后的json数据
            Thread.sleep(500000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
