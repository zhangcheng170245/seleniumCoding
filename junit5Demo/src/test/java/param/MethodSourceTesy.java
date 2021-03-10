package param;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @Author: zhangcheng
 * @Description: 方法参数化
 * @Date: 2021/3/10/010 10:10
 * @Version: 1.0
 */
public class MethodSourceTesy {

    @ParameterizedTest
    @MethodSource("dataProvider")
    void testWithMethod(String arg){
        assertNotNull(arg);
    }
    // 参数方法
    static Stream<String> dataProvider(){
        return Stream.of("apple","banna");
    }

}
