package TestNGExample.uat;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/11/011 22:36
 * @Version: 1.0
 */
public class case2 {
    public int count = 0;

    @Test(threadPoolSize = 10, invocationCount = 100)
    public void pushBothRentAndLeadsMq() throws Exception {
        String phone = "15117779658";
        String specName = "客源宝+分发+S";
        String providerId = "85011409";
        String productId = "33";
        String stageType = "0";
        String activityType = "0";
        String originType = "0";
        String leadsLevel = "B";
        String price = "15.33";
        pushAlotMq(productId, stageType, activityType, originType, providerId, leadsLevel, phone, specName, price);
        count++;
    }
    public void pushAlotMq(String productId, String stageType, String activityType, String originType, String providerId, String leadsLevel, String phone, String specName, String price) {
        System.out.println(specName + "==>手机号：" + phone + "||来源类型：" + stageType + "||入口类型：" + activityType + "||落地页类型：" + originType + "||线索级别：" + leadsLevel + "||商家ID：" + providerId + "||刊例价：" + price);


    }

    @AfterClass
    public void printcount() {
        System.out.println(count);
    }
    }
