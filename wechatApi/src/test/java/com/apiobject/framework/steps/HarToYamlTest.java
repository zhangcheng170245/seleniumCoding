package com.apiobject.framework.steps;

import com.apiobject.framework.actions.ApiActionModel;
import com.apiobject.framework.api.ApiObjectModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import de.sstoehr.harreader.HarReader;
import de.sstoehr.harreader.HarReaderException;
import de.sstoehr.harreader.model.Har;
import de.sstoehr.harreader.model.HarRequest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;


/**
 * @Author: zhangcheng
 * @Description: har文件转yaml
 * @Date: 2021/1/2 20:26
 * @Version: 1.0
 */
public class HarToYamlTest {
    public static final Logger logger = LoggerFactory.getLogger(HarToYamlTest.class);

    @Test
    void harTest() throws HarReaderException, IOException {
        HarReader harReader = new HarReader();
        Har har = harReader.readFromFile(new File("src/test/resources/har/qyapi.weixin.qq.com.har"));
        logger.info("debugger");

        ApiObjectModel apiObjectModel = new ApiObjectModel(); // 接口对象
        ApiActionModel apiActionModel = new ApiActionModel(); //接口动作
        HashMap<String, ApiActionModel> actions = new HashMap<>();
        HashMap<String, String> queryMaps = new HashMap<>();
        //遍历
        har.getLog().getEntries().forEach(
                entire->{
                    HarRequest harRequest = entire.getRequest(); //获取请求体
                    harRequest.getQueryString().forEach(queryParam->{  //遍历取出 姓名，值
                        queryMaps.put(queryParam.getName(),queryParam.getValue()); //使用queymaps 取出相关参数
                    });
                    String method = harRequest.getMethod().toString(); //请求方法
                    String url = harRequest.getUrl(); //请求url
                    apiActionModel.setQuery(queryMaps); //设置请求参数
                    if (method.equals("post")){
                        apiActionModel.setPost(url);
                    }else{
                        apiActionModel.setGet(url);
                    }

                    actions.put(getRequestName(url),apiActionModel);
                });
        apiObjectModel.setName("tokenhelper"); //生成的文件名
        apiObjectModel.setActions(actions); //生成的参数
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(new File("src/test/resources/har/tokenhelper.yaml"),apiObjectModel);

    }

    public String getRequestName(String url) {
        String[] suburl = url.split("\\u003F")[0].split("/");
        String name = "";
        if (suburl.length > 1) {
            name = suburl[suburl.length - 1];
        }else if(1==suburl.length){
            name = suburl[0];
        }
        return name;
    }

    @Test
    public void runTest() throws IOException {
        ApiObjectModel apiObjectModel=ApiObjectModel.load("src/test/resources/har/tokenhelper.yaml");
        apiObjectModel.getActions().get("gettoken").run(null);


    }

}
