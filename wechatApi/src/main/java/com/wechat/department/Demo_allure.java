package com.wechat.department;

import com.wechat.EvnHelperTask.EvnHelperTask;
import com.wechat.apiPo.DepartMentObj;
import com.wechat.apiPo.TokenUtil;
import com.wechat.utils.FakerUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: zhangcheng
 * @Description: 解耦的脚本
 * @Date: 2020/12/20 17:52
 * @Version: 1.0  allure2注解举例
 *  */

@Epic("Epic企业微信接口测试用例")
@Feature("Feature部门相关功能测试")
public class Demo_allure {
    private static final Logger logger = LoggerFactory.getLogger(Demo_allure.class);
    static String accessToken;

    @BeforeAll
    public  static  void  getAccessToken(){
         accessToken = TokenUtil.getAccessToken();
         logger.info(accessToken);
    }
    //数据清理  每次用例启动结束时执
    @BeforeEach
    @AfterEach
    void clearDepartment(){
        EvnHelperTask.clearDpartMentTask(accessToken);
    }

    @Description("Description这个测试方法会测试创建部门的功能-入参数据驱动")
    @Story("stroy创建部门测试")
    @DisplayName("DisplayName创建部门")
    @ParameterizedTest
    @CsvFileSource(resources = "/data/createDepartment.csv", numLinesToSkip = 1)
    void createDepartment(String creatName, String creatEnName, String returnCode) {
        Response response=DepartMentObj.creatDepartMent(creatName,creatEnName,accessToken);
        assertEquals(returnCode,response.path("errcode").toString());
    }

    @Description("Description这个测试方法会测试修改部门的功能")
    @Story("Story修改部门测试")
    @DisplayName("DisplayName修改部门")
    @Test
    void updateDepartment() {
        // 姓名添加时间戳 防重
        String updateName= "orange"+ FakerUtils.getTimeStamp();
        String updateEnName = "en_name"+FakerUtils.getTimeStamp();
        String departMentId= DepartMentObj.creatDepartMent(accessToken);

        Response updateResponse =DepartMentObj.updateDepartMent(updateName,updateEnName,departMentId,accessToken);

        assertEquals("0",updateResponse.path("errcode").toString());
    }

    @DisplayName("DisplayName查询部门")
    @Description("Description这个测试方法会测试查询部门的功能")
    @Story("Story查询部门测试")
    @Test
    void listDepartment() {
        String creatName= "orange"+ FakerUtils.getTimeStamp();
        String creatEnName = "en_name"+FakerUtils.getTimeStamp();

        // 获取部门id
        Response creatResponse = DepartMentObj.creatDepartMent(creatName,creatEnName,accessToken);
        String departMentId= creatResponse.path("id")!=null ? creatResponse.path("id").toString():null;

        Response listResponse = DepartMentObj.listDepartMent(departMentId, accessToken);
        //todo  使用拉姆达表达
       /* assertEquals("1",listResponse.path("errcode").toString());
        assertEquals(departmentId+"x",listResponse.path("department.id[0]").toString());
        assertEquals(creatName+"x",listResponse.path("department.name[0]").toString());
        assertEquals(creatEnName+"x",listResponse.path("department.name_en[0]").toString());*/
        assertAll("查询返回值校验",
                () ->assertEquals("0",listResponse.path("errcode").toString()),
                ()->assertEquals(departMentId,listResponse.path("department.id[0]").toString()),
                ()->assertEquals(creatName,listResponse.path("department.name[0]").toString()),
                ()->assertEquals(creatEnName,listResponse.path("department.name_en[0]").toString())

        );


    }

    @DisplayName("DisplayName删除部门")
    @Description("Description这个测试方法会测试删除部门的功能")
    @Story("Story删除部门测试")
    @Test
    void deleteDepartment() {
        // 获取部门id
        String departMentId= DepartMentObj.creatDepartMent(accessToken);
        Response response=DepartMentObj.deletDepartMent(departMentId,accessToken);

        assertEquals("0",response.path("errcode").toString());

    }

    }