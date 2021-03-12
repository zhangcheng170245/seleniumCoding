package FailRetry;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: zhangcheng
 * @Description: 重写监听器
 * @Date: 2021/3/12/012 12:00
 * @Version: 1.0
 */
public class OverrideTransformer implements IAnnotationTransformer  {

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass,
                          Constructor constructor, Method method) {

        ///获取到retryAnalyzer的注解
        try {
            IRetryAnalyzer analyzer =
                    iTestAnnotation.getRetryAnalyzerClass().getDeclaredConstructor().newInstance();
            if (analyzer == null || !(analyzer instanceof OverrideIReTry)) {
                iTestAnnotation.setRetryAnalyzer(OverrideIReTry.class);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

       }
    }
