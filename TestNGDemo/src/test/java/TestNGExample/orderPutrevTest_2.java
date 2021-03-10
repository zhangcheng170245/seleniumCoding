package TestNGExample;

import org.testng.annotations.Test;

/**
 * @Author: zhangcheng
 * @Description: 装载后并记录
 * @Date: 2021/3/9/009 17:18
 * @Version: 1.0
 */
public class orderPutrevTest_2 {

    @Test
    public void putInA() throws Exception {
        System.out.print("装入坚果 A \n");
        System.out.print("1号头盔哥记录 \n");
    }

    @Test
    public void putInB() throws Exception {
        System.out.print("装入坚果 B\n");
        System.out.print("2号头盔哥记录 \n");
    }

    @Test
    public void putInC() throws Exception {
        System.out.print("装入坚果 C\n");
        System.out.print("3号头盔哥记录 \n");
    }

    @Test
    public void putInD() throws Exception {
        System.out.print("装入坚果 D\n");
        System.out.print("4号头盔哥记录 \n");
    }

    @Test
    public void putInE() throws Exception {
        System.out.print("装入坚果 E\n");
        System.out.print("5号头盔哥记录 \n");
    }
}

