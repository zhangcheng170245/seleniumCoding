package JunitDemo5;

import org.junit.jupiter.api.*;

/**
 * @Author: zhangcheng
 * @Description:子类继承父类测试方法执行顺序:
 *             相同优先级，父类先进，子类先出
 * @Date: 2021/3/10/010 16:25
 * @Version: 1.0
 */
public class Junit5Demo_Fixtures1 extends Junit5Demo_Fixtures {
    @BeforeAll
    static void childBeforeAll() {
        System.out.println("child BeforeAll 执行了!");
    }

    @AfterAll
    static void childAfterAll() {
        System.out.println("child AfterAll 执行了!");
    }


    @BeforeEach
    void childBeforEach() {
        System.out.println("child BeforEach 执行了!");
    }

    @AfterEach
    void childAfterEach() {
        System.out.println("child AfterEach 执行了!");
    }

    @Test
    void childTestMethod01() {
        System.out.println("child TestMethod01 执行了!");
    }

    @Test
    void childTestMethod02() {
        System.out.println("child TestMethod02 执行了!");
    }


}
