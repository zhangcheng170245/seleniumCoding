package JunitDemo5;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @Author: zhangcheng
 * @Description: 依赖测试
 * @Date: 2021/3/9/009 23:20
 * @Version: 1.0
 */
public class LoginTest {

    // 存放测试数据
      private  static HashMap<String,Object> data= new HashMap<String,Object>();

        @Test
        void loginTest(){
          data.put("orange","登录成功");
          //m模拟获取用户登录状态
          System.out.println(data.get("orange"));
      }

       @Nested ///@Nested修饰类倒序执行
        class  BuyTest{
          @Test
          void buy(){
            // 判断是否登录成功
            if (null!= data.get("buy")){
              System.out.println("正在支付 --先执行");
              // 判断用户是否正常登录
              System.out.println(data.get("orange"));
            }else {
              System.out.println(" 请登录~~~~");
            }
          }
        }


        @Nested
        class  BuyTesttoo{
          @Test
          void buyToo(){
            // 判断是否登录成功
            if (data.get("orange").equals("登录成功==先执行")) {
              System.out.println("登录成功，可以购买东西了");

              data.put("buy","苹果汽车购买成功");
            } else {
              System.out.println("登录失败，请重新登录");
            }
        }
      }

}