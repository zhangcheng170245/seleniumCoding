package TestNGExample.uat;

import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/11/011 22:41
 * @Version: 1.0
 */
public class Case_3_2_ThreadSafe {

    private String[] nuts = new String[]{"C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10"};

    private int i = 0;


    @Test(threadPoolSize = 5, invocationCount = 10, timeOut = 60000)
    public void putInC01() throws Exception {
        long id = Thread.currentThread().getId();
        String nut = nuts[i];
        System.out.print("线程号" + id + "==>装入坚果 " + nut + "\n");
        i++;
    }


    //使用关键字对AtomicInteger保证变量自增的原子性
    private AtomicInteger j = new AtomicInteger(0);


    @Test(threadPoolSize = 5, invocationCount = 10, timeOut = 60000)
    public void putInC02() throws Exception {
        Thread.sleep(1000);
        long id = Thread.currentThread().getId();
        String nut = nuts[j.getAndIncrement()];
        System.out.print("线程号" + id + "==>装入坚果 " + nut + "\n");
    }

    //使用关键字synchronized保证逻辑的互斥访问
    @Test(threadPoolSize = 5, invocationCount = 10, timeOut = 60000)
    public void putInC03() throws Exception {
        long id = Thread.currentThread().getId();
        synchronized (this) {
            String nut = nuts[i];
            System.out.print("线程号" + id + "==>装入坚果 " + nut + "\n");
            i++;
        }
    }
}

