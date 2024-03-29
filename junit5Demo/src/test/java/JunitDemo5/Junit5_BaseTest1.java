package JunitDemo5;

import org.junit.jupiter.api.*;

/**
 * @Author: zhangcheng
 * @Description: 重复执行顺序执行
 * @Date: 2021/3/9/009 22:40
 * @Version: 1.0
 */
@DisplayName("junit5执行顺序")
public class Junit5_BaseTest1 {
    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll---执行前");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }

    @DisplayName("fun 测试方法")
    @RepeatedTest(5)
        // 重复测试
    void fun() {
//      如果是junit4 需要public修饰
        System.out.println("测试方法~1");
    }

    @Test
    @Disabled  //执行时，跳过此方法
    @DisplayName("fun1 测试方法")
    void fun1() {
        System.out.println("测试方法~2");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }


}
