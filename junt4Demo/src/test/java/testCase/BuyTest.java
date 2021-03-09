package testCase;

import org.junit.Test;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/9/009 16:43
 * @Version: 1.0
 */
public class BuyTest extends  BaseTest {

    @Test
    public void buy(){
        //验证用户是否登录 成功
      if ( dataMap.get("orange").equals("登录成功")){
          System.out.println("登录成功,可以买~");
      }else{
          System.out.println("请登录~");
      };

    }
}
