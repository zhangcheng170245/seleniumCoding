package com.wechat.department;

import com.wechat.EvnHelperTask.UserClearTask;
import com.wechat.apiPo.TokenUtil;
import com.wechat.apiPo.UserObj;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: zhangcheng
 * @Description: 创建用户
 * @Date: 2020/12/23 22:37
 * @Version: 1.0
 */

@Epic("Epic企业微信接口测试用例")
@Feature("Feature用户相关功能测试")
public class CreateUser_allure {

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
    void clearUser(){
         UserClearTask.clearUserClearTask(accessToken);
    }

    @Description("Description这个测试方法会测试创建用户的功能-入参数据驱动")
    @Story("stroy创建用户测试")
    @DisplayName("DisplayName创建用户")
    @ParameterizedTest
    @CsvFileSource(resources = "/data/createUser.csv", numLinesToSkip = 1)
    void setCreatName(String userid, String name, String alias,String department,String moblile,String returnCode) {
        Response response = UserObj.creatUser(userid, name,alias,department, moblile,accessToken);
        assertEquals(returnCode,response.path("errcode").toString());
        logger.info(accessToken);
    }


    @Description("Description这个测试方法会查询当前成员")
    @DisplayName("Story显示成员列表")
    @Story("stroy查询用户测试")
    @Test
    void listUser(){
        //获取根目录下所有成员
        Response listResponse = UserObj.listUser("2",accessToken);
        assertEquals("0",listResponse.path("errcode").toString());
        logger.info(listResponse.toString());
    }

    @Description("Description这个测试方法会测试修改成员的功能")
    @Story("Story修改成员信息测试")
    @DisplayName("DisplayName修改成员信息")
    @Test
    void updateUser() {
        String userid="userid"+ FakerUtils.getTimeStamp();
        String name="name"+ FakerUtils.getTimeStamp();
        String alias="alias"+ FakerUtils.getTimeStamp();
        String department="1";
        String mobile= FakerUtils.getTel();
        //先创建用户
        UserObj.creatUser(userid, name, alias, department, mobile, accessToken);
        //查询用户
        Response listUser = UserObj.listUser("2", accessToken);
        // 获取新增用户userid
        String updateUserId  = listUser.path("userlist[-1].userid");
        System.out.println("================" +updateUserId);
        String updateName="updateName"+ FakerUtils.getTimeStamp();
        String updateAlias="updateAlias"+ FakerUtils.getTimeStamp();
        String upDatemobile= FakerUtils.getTel();
        Response updateResponse = UserObj.updateUser(updateUserId,updateName,updateAlias,department,upDatemobile,accessToken);
        assertEquals("0",updateResponse.path("errcode").toString());
    }


    @Description("Description这个测试方法会测试删除人员的功能")
    @Story("Story删除人员测试")
    @DisplayName("DisplayName删除人员")
    @Test
    void deleteUser() {
        //创建用户
        String userid="CC"+FakerUtils.getTimeStamp();
        String name="ZZ"+FakerUtils.getTimeStamp();
        String alias ="ZS"+FakerUtils.getTimeStamp();
        String departmentId="2";  //使用子部门
        String mobile=FakerUtils.getTel();
        UserObj.creatUser(userid,name,alias,departmentId,mobile,accessToken);
        //查询用户
        Response listUser = UserObj.listUser("2", accessToken);
        // 获取新增用户userid
        String createUserId  = listUser.path("userlist[-1].userid");
        Response deleteResponse= UserObj.delteUser(createUserId,accessToken);
        assertEquals("0",deleteResponse.path("errcode").toString());
    }
}
