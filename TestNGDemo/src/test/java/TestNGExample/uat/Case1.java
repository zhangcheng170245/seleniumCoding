package TestNGExample.uat;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.FakerUtils;

import java.io.IOException;


/**
 * @Author: zhangcheng
 * @Description: 模拟生产环境 mq推送
 * @Date: 2021/3/11/011 22:00
 * @Version: 1.0
 */
public class Case1 {
    public int count = 0;

    //读取csv数据
    @DataProvider(name = "testData")
    public Object[][] putInList() throws IOException {
        return FakerUtils.getTestData("/src/main/resources/data/leadsallinone.csv");
    }

    // mq测试
    //invocationC ount 表示执行的次数
    //threadPoolSize  表示线程池的内线程的个数
    //timeOut  超时时间-毫秒
    @Test(threadPoolSize = 1, invocationCount = 1, dataProvider = "testData")
    public void pushBothRentAndLeadsMq(String specName, String providerId, String productId, String stageType,
                                       String activityType, String originType, String leadsLevel, String source, String runAble, String price) throws Exception {
        //生成随机手机号
        String phone = "15117" + FakerUtils.getRandomInt(6);
        if (runAble.equals("1")) {
            if (source.equals("1")) {
                pushAlotMQ(productId, stageType, activityType, originType, providerId, leadsLevel, phone, specName, price);
            } else if (source.equals("2")) {
                rushLeadsApi(productId, stageType, activityType, originType, providerId, leadsLevel, phone, specName, price);
            } else {
                System.out.println("source值错误！");
            }
        }
        count++;
    }


    // h
    public void pushAlotMQ(String productId, String stageType, String activityType, String originType, String providerId, String leadsLevel, String phone, String specName, String price) {
        System.out.println(specName + "==>手机号：" + phone + "||来源类型：" + stageType + "||入口类型：" + activityType + "||落地页类型：" + originType + "||线索级别：" + leadsLevel + "||商家ID：" + providerId + "||产品ID：" + productId + "||刊例价：" + price);

    }

    public void rushLeadsApi(String productId, String stageType, String activityType, String originType, String providerId, String leadsLevel, String phone, String specName, String price) {
        System.out.println(specName + "==>手机号：" + phone + "||来源类型：" + stageType + "||入口类型：" + activityType + "||落地页类型：" + originType + "||线索级别：" + leadsLevel + "||商家ID：" + providerId + "||产品ID：" + productId + "||刊例价：" + price);


    }


    @AfterClass
    public void printcount() {
        System.out.println(count);
    }
    }