package testCase;

import org.junit.Test;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/9/009 16:43
 * @Version: 1.0
 */
public class LoginTest extends  BaseTest {

    @Test
    public  void login(){
        // 模拟用户登录
        dataMap.put("orange","登录成功") ;
        System.out.println("用户：orange 登录成功");
    }
}
