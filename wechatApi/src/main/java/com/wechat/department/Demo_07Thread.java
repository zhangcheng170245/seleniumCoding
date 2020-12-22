package com.wechat.department;

import com.wechat.EvnHelperTask.EvnHelperTask;
import com.wechat.apiPo.DepartMentObj;
import com.wechat.apiPo.TokenUtil;
import com.wechat.utils.FakerUtils;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: zhangcheng
 * @Description: 解耦的脚本
 * @Date: 2020/12/20 17:52
 * @Version: 1.0
创建部门多线程测试
 *  */

public class Demo_07Thread {
    private static final Logger logger = LoggerFactory.getLogger(Demo_03_timestamp_evnclear.class);
    static String departmentId;
    static String accessToken;


    @BeforeAll
    public  static  void  getAccessToken(){
         accessToken = TokenUtil.getAccessToken();
    }
    //数据清理  每次用例启动结束时执行
  /*  @BeforeEach
    @AfterEach*/
    void clearDepartment(){
        EvnHelperTask.clearDpartMentTask(accessToken);

    }

    @DisplayName("创建部门")
    @RepeatedTest(100)
    @Execution(ExecutionMode.CONCURRENT)
    void createDepartment() {
        String name= "橙子大王"+ FakerUtils.getTimeStamp();
        String enName="enName"+FakerUtils.getTimeStamp();

        Response response=DepartMentObj.creatDepartMent(name,enName,accessToken);
        assertEquals("0",response.path("errcode").toString());
    }


}