package FailRetry;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * @Author: zhangcheng
 * @Description: 实现重试机制
 * @Date: 2021/3/12/012 11:31
 * @Version: 1.0
 */
public class OverrideIReTry implements IRetryAnalyzer {
    // 日志
    public static Logger logger= Logger.getLogger(OverrideIReTry.class);
    //初始化重试次数
    public int retryCount=0;
    //最大重试次数
    private static int MaxRetryCount;
    static {
        // 失败后次数+1 等于重试4次~
        MaxRetryCount=3;
        logger.info("重试次数="+MaxRetryCount);
    }

    /**
     *
     * @param iTestResult 测试结果
     * @return
     */
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount <= MaxRetryCount){
          /*  String message = "running retry for " + iTestResult.getName() + "' on class " +
                    this.getClass().getName() + " Retrying " + retryCount + " times";*/
            String msg = "执行用例："+iTestResult.getName()+"第"+retryCount+"次运行失败";
            System.out.println(msg);
            logger.info(msg);
            Reporter.log("RunCount=" + (retryCount + 1));
            retryCount++;
            return true;
        }
        return false;
    }

}
