package suite;

import com.testcase.testcase1.Junit5Demo1Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 * @Author: zhangcheng
 * @Description: 测试套件
 * @Date: 2021/3/9/009 23:47
 * @Version: 1.0
 */


// 使用方式1
/*@RunWith(JUnitPlatform.class)
@SelectPackages({
        "com.testcase.testcase1", "com.testcase.testcase2"   //包所在位置
})
public class Junit5SuiteDemoTest {
}*/

@RunWith(JUnitPlatform.class)
@SelectPackages({
        "com.testcase"
})
@IncludePackages({
        "com.testcase.testcase1", "com.testcase.testcase3"
})


//指定测试类，测试方法范围
@SelectClasses({Junit5Demo1Test.class})
@IncludeTags({"testsuiteDemo"})
public class Junit5SuiteDemoTest {
}
