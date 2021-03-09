package suiteDemo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testCase.BuyTest;
import testCase.LoginTest;

/**
 * @Author: zhangcheng
 * @Description: 套件测试
 * @Date: 2021/3/9/009 16:41
 * @Version: 1.0
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({  // 类放置位置会影响执行顺序
        LoginTest.class, BuyTest.class
})
public class suiteDemoTest {
}
