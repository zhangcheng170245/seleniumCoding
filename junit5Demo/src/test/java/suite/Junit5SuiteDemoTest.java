package suite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import testcase1.Junit5Demo1Test;

/**
 * @Author: zhangcheng
 * @Description: 测试套件
 * @Date: 2021/3/9/009 23:47
 * @Version: 1.0
 */

@RunWith(JUnitPlatform.class)
/*@SelectPackages({
        "testcase1","testcase2"   //包所在位置
})*/
//指定测试类，测试方法范围
@SelectClasses({Junit5Demo1Test.class})
@IncludeTags({"testdemo"})
public class Junit5SuiteDemoTest {
}
