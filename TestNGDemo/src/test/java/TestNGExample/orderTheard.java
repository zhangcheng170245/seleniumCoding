package TestNGExample;

import org.testng.annotations.Test;

/**
 * @Author: zhangcheng
 * @Description: 多线程测试
 * @Date: 2021/3/9/009 17:37
 * @Version: 1.0
 */
public class orderTheard {

    @Test
public void putInA() throws Exception {
    Thread.sleep(1000);
    System.out.print("装入坚果 A \n");
}

    @Test
    public void putInB() throws Exception {
        Thread.sleep(1000);

        System.out.print("装入坚果 B\n");
    }

    @Test(threadPoolSize = 5, invocationCount = 5, timeOut = 60000)  //5个线程执行5次
    public void putInC() throws Exception {
        Thread.sleep(1000);
        long id = Thread.currentThread().getId();
        System.out.print("线程号" + id + "==>装入坚果 C\n");
    }

    @Test
    public void putInD() throws Exception {
        Thread.sleep(1000);
        System.out.print("装入坚果 D\n");
    }

    @Test
    public void putInE() throws Exception {
        Thread.sleep(1000);
        System.out.print("装入坚果 E\n");
    }
}
