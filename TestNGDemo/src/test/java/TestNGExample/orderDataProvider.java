package TestNGExample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @Author: zhangcheng
 * @Description: 数据驱动
 * @Date: 2021/3/9/009 17:45
 * @Version: 1.0
 */
public class orderDataProvider {

    @DataProvider(name = "putInList")
    public Object[][] putInList() {
        Object[][] object;
        return object = new Object[][]{
                {"包裹1", 1, 0, 1, 1, 1,},
                {"包裹2", 0, 1, 1, 1, 0,},
                {"包裹3", 1, 1, 1, 1, 1,},
        };
    }
    @Test(dataProvider = "putInList")
    public void putIN(String pakageName, int aNum, int bNum, int cNum, int dNum, int eNum) throws InterruptedException {
        System.out.print("忧伤哥 操作" + pakageName + " 装入坚果A " + aNum + " 个！\n");
        Thread.sleep(1000);
        System.out.print("炫酷哥 操作" + pakageName + " 装入坚果B " + bNum + " 个！\n");
        Thread.sleep(1000);
        System.out.print("羞涩哥 操作" + pakageName + " 装入坚果C " + cNum + " 个！\n");
        Thread.sleep(1000);
        System.out.print("暴怒哥 操作" + pakageName + " 装入坚果D " + dNum + " 个！\n");
        Thread.sleep(1000);
        System.out.print("傻笑哥 操作" + pakageName + " 装入坚果E " + eNum + " 个！\n");
        Thread.sleep(1000);
    }
}
