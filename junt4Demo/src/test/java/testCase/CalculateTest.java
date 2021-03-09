package testCase;

import org.junit.*;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/9/009 16:36
 * @Version: 1.0
 */
public class CalculateTest {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    System.out.println("this is before class");
}

    /**
     * @AfterClass:这个注解表示这个方法会在所有方法执行完毕之后执行，通常用来释放资源
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("this is after class");
    }

    /**
     * @Before:这个注解表示这个方法会在每个测试方法执行之前执行一次
     * 有多少个测试方法就会执行多少次
     */
    @Before
    public void setUp() throws Exception {
        System.out.println("测试执行前");
    }

    /**
     * @After:这个注解表示这个方法会在每个测试方法执行之后执行一次有多少个测试方法就会执行多少次
     */
    @After
    public void tearDown() throws Exception {
        System.out.println("测试执行后");
    }

    @Test
    public void test1() {
        System.out.println("测试1方法执行中");
    }

    @Test
    public void test2() {
        System.out.println("测试2方法执行中");
    }

}