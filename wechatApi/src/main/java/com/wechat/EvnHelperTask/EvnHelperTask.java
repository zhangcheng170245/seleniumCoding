package com.wechat.EvnHelperTask;

import com.wechat.apiPo.DepartMentObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2020/12/20 23:35
 * @Version: 1.0
 */
public class EvnHelperTask {
    private static final Logger logger = LoggerFactory.getLogger(EvnHelperTask.class);

    public static void clearDpartMentTask(String accessToken){

        ArrayList<Integer> departmentIds = DepartMentObj.listDepartMent("",accessToken).path("department.id");
        for( int departmentId:departmentIds){
            if(1==departmentId)
                continue;
            DepartMentObj.deletDepartMent(departmentId+"",accessToken);
        }
    }
}

