package JunitDemo5;

import org.junit.jupiter.api.*;

/**
 * @Author: zhangcheng
 * @Description: 测试场景
 * @Date: 2021/3/10/010 16:21
 * @Version: 1.0
 * 基类@BeforeClass 配置初始化，初始化driver，安装启动app等
 * 基类@AfterClass 退出前清理环境
 */
public class Junit5Demo_Fixtures {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Father BeforeAll 执行了!");
    }

    @BeforeEach
    void beforEach() {
        System.out.println("Father BeforeEach 执行了!");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Father AfterEach 执行了!");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Father AfterAll 执行了!");
    }


    @Test
    void testMethod01() {
        System.out.println("Father testMethod01 执行了!");
    }

    @Test
    void testMethod02() {
        System.out.println("Father testMethod0102 执行了!");
    }
}

