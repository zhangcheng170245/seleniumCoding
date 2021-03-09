package TestNGExample;

import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zhangcheng
 * @Description: 增加原子性
 * @Date: 2021/3/9/009 17:42
 * @Version: 1.0
 */
public class orderTheardUpu {
    private String[] nuts = new String[]{"C1", "C2", "C3", "C4", "C5"};

    private  int i=0;

    @Test(threadPoolSize = 5, invocationCount = 5, timeOut = 60000)
    public void putInC01() throws Exception {
        Thread.sleep(1000);
        long id = Thread.currentThread().getId();
        String nut = nuts[i++];
        System.out.print("线程号" + id + "==>装入坚果 " + nut + "\n");
    }


    //使用关键字对AtomicInteger保证变量自增的原子性
    private AtomicInteger j = new AtomicInteger(0);

    @Test(threadPoolSize = 5, invocationCount = 5, timeOut = 60000)
    public void putInC02() throws Exception {
        Thread.sleep(1000);
        long id = Thread.currentThread().getId();
        String nut = nuts[j.getAndIncrement()];
        System.out.print("线程号" + id + "==>装入坚果 " + nut + "\n");
    }
}
