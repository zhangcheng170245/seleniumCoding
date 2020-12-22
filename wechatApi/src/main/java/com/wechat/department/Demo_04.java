package com.wechat.department;

import com.wechat.EvnHelperTask.EvnHelperTask;
import com.wechat.apiPo.DepartMentObj;
import com.wechat.apiPo.TokenUtil;
import com.wechat.utils.FakerUtils;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: zhangcheng
 * @Description: 解耦的脚本
 * @Date: 2020/12/20 17:52
 * @Version: 1.0
 *  * 1、基础脚本，分别执行了，创建、修改、查询、删除接口并进行了校验
 *  * 2、进行了优化，方法间进行解耦，每个方法可以独立行
 *    3  时间戳命令防止重名
 *    4、进行了优化，每次方法执行前后都对历史数据进行清理，确保每次执行脚本数据环境一致。
 *    5、进行了优化，对脚本进行了分层，减少了重复代码，提高了代码复用率，并减少了维护成本。
 *  */

public class Demo_04 {
    private static final Logger logger = LoggerFactory.getLogger(Demo_03_timestamp_evnclear.class);
    static String departmentId;
    static String accessToken;


    @BeforeAll
    public  static  void  getAccessToken(){
         accessToken = TokenUtil.getAccessToken();
    }
    //数据清理  每次用例启动结束时执行
    @BeforeEach
    @AfterEach
    void clearDepartment(){
        EvnHelperTask.clearDpartMentTask(accessToken);

    }

    @DisplayName("创建部门")
    @Test
    @Order(1)
    void createDepartment() {
        // 姓名添加时间戳 防重
        String name= "橙子大王"+ FakerUtils.getTimeStamp();
        String enName="enName"+FakerUtils.getTimeStamp();

        Response response = DepartMentObj.creatDepartMent(name, enName, accessToken);
        assertEquals("0",response.path("errcode").toString());

    }
    @DisplayName("修改部门")
    @Test
    @Order(2)
    void updateDepartment() {
        // 姓名添加时间戳 防重
        String updateName= "橙子大王"+ FakerUtils.getTimeStamp();
        String updateEnName= DepartMentObj.creatDepartMent(accessToken);

        Response updateResponse =DepartMentObj.updateDepartMent(updateName,updateEnName,departmentId,accessToken);

        assertEquals("0",updateResponse.path("errcode").toString());

    }

    @DisplayName("查询部门")
    @Test
    @Order(3)
    void listDepartment() {
        // 获取部门id
        String departMentId= DepartMentObj.creatDepartMent(accessToken);
        Response response = DepartMentObj.listDepartMent(departMentId, accessToken);

        assertEquals("0",response.path("errcode").toString());
        assertEquals(departmentId,response.path("department.id[0]").toString());

    }
    @DisplayName("删除部门")
    @Test
    @Order(4)
    void deleteDepartment() {
        // 获取部门id
        String departMentId= DepartMentObj.creatDepartMent(accessToken);
        Response response=DepartMentObj.deletDepartMent(departMentId,accessToken);

        assertEquals("0",response.path("errcode").toString());

    }
}