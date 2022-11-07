package CalcuatorTest;

/**
 * @ProjectName: seleniumCoding
 * @Package: CalcuatorTest
 * @ClassName: TestBuffer
 * @Author: 还是那个橙子
 * @Description: 字符串
 * @Date: 2022/11/7 21:52
 * @Version: 1.0
 */

public class TestBuffer {
    private static final String ALLURE_SUMMARY_URL_FORMAT = "http://%s/job/%s/allure/widgets/summary.json";

    public static void main(String[] args) {
        String host="121,12";

        String module="SDASDA";
        String url = String.format(ALLURE_SUMMARY_URL_FORMAT,host,module);
        System.out.println(url);
    }
}
