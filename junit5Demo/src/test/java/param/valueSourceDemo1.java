package param;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: zhangcheng
 * @Description: 参数化 --简单参数源
 * @Date: 2021/3/10/010 8:16
 * @Version: 1.0
 */
public class valueSourceDemo1 {

    @ParameterizedTest
    @ValueSource(ints = {4,8,12})
    void test1(int num){
        assertEquals(0, num % 2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Radar", "Rotor", "Tenet", "Madam", "Racecar"}) // string 类型参数化
    void testStringShouldBePalindrome(String word) {
        assertEquals(isPalindrome(word), true);
    }

    @ParameterizedTest
    @ValueSource(doubles = {2.D, 4.D, 8.D})
    void testDoubleNumberBeEven(double num) {
        assertEquals(0, num % 2);
    }

    boolean isPalindrome(String word) {  // 大小写
        return word.toLowerCase().equals(new StringBuffer(
                word.toLowerCase()).reverse().toString());
    }
}


