package test_web.wework.service;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * @Author: zhangcheng
 * @Description: 浏览器代理
 * @Date: 2020/12/13 17:27
 * @Version: 1.0
 */
public class BMPTest {


    @Test
    public void bmp() throws IOException {
        //new net.lightbody.bmp.proxy.

        //开始代理
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(8088);
        int port = proxy.getPort(); // get the JVM-assigned port
        // Selenium or HTTP client configuration goes here
        //拦截修改模式  智能mock
        proxy.addResponseFilter((response, contents, messageInfo) -> {
            //修改返回内容
            if (messageInfo.getOriginalUrl().contains(".json")) { // 匹配所有的json、
                // TODO json转换  json->hashmap->递归->new hashmap-> json
                String contentNew = contents.getTextContents().replaceAll(":\"[^\"]*\"", "null");//把所有的值改成 null
                contents.setTextContents(contentNew);
                //todo   curl -k https://ceshiren.com/categories.json -x http://127.0.0.1:8088  文件替换成功
                //contents.setTextContents("This message body will appear in all responses!");
            }
        });
        proxy.addRequestFilter(((request, contents, messageInfo) -> {
            request.setUri("/");
            return null;


        }));

        System.in.read();
    }

    //简单的服务器
    public static void main(String[] args) {
        port(8099);
        get("/hello", (req, res) -> "Hello World");
        get("/proxy", (req, res) -> {
            BrowserMobProxy proxy = new BrowserMobProxyServer();
            System.out.println(req.port());
            proxy.start(req.port());
            return null;
        });
    }


}
