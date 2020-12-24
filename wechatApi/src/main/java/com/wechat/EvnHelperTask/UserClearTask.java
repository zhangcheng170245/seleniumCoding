package com.wechat.EvnHelperTask;

import com.wechat.apiPo.UserObj;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * @Author: zhangcheng
 * @Description: 新建用户清理
 * @Date: 2020/12/23 23:31
 * @Version: 1.0
 */
public class UserClearTask {
    private static final Logger logger = LoggerFactory.getLogger(UserClearTask.class);

    //删除列表下的指定用户
    public static void clearUserClearTask(String accessToken){

        Response response =UserObj.listUser("2",accessToken);  //查询添加人员专用部门的列表
        ArrayList<String> userList= response.path("userlist.userid");
        for( String userId:userList){
            UserObj.delteUser(userId+"",accessToken);
        }
    }
}


