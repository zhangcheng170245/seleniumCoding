package FailRetry;

import easyRetry.OverrideIReTry;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author: zhangcheng
 * @Description: 重写监听器
 * @Date: 2021/3/12/012 12:00
 * @Version: 1.0
 */
public class RetryListener implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass,
                          Constructor constructor, Method method) {
        iTestAnnotation.setRetryAnalyzer(OverrideIReTry.class);
    }
}