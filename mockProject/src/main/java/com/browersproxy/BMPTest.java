package com.browersproxy;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author: zhangcheng
 * @Description: browersProxy测试
 * @Date: 2021/3/17/017 11:37
 * @Version: 1.0
 */
public class BMPTest {

    @Test
    public void bmp() throws IOException {
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(8086);
        int port = proxy.getPort();
            proxy.addResponseFilter((response,contents,messageInfo)->{
                if (messageInfo.getOriginalUrl().contains(".json")){ //匹配所有的json
                    //todo 使用jackson 将 json 转化为 hashmap ->递归 ->改为新的hashmap->json
                    String neWcontents = contents.getTextContents().replaceAll(":\"[^\"]*\"", "null");// 将字符串改为null
                    contents.setTextContents(neWcontents);
                }
            });
        System.in.read();
    }

}
