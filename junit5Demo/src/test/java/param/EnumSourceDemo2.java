package param;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author: zhangcheng
 * @Description: 枚举参数源
 * @Date: 2021/3/10/010 8:31
 * @Version: 1.0
 */
public class EnumSourceDemo2 {

    @ParameterizedTest(name = "[{index}] TimeUnit: {arguments}")
    @EnumSource(TimeUnit.class)
    void testTimeUnitMinimumNanos(TimeUnit unit) {
        assertTrue(unit.toMillis(2000000L) > 1);
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, names = {"SECONDS", "MINUTES"})
    void testTimeUnitJustSecondsAndMinutes(TimeUnit unit) {
        assertTrue(EnumSet.of(TimeUnit.SECONDS, TimeUnit.MINUTES).contains(unit));
        assertFalse(EnumSet
                .of(TimeUnit.DAYS, TimeUnit.HOURS, TimeUnit.MILLISECONDS, TimeUnit.NANOSECONDS,
                        TimeUnit.MICROSECONDS).contains(unit));
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, mode = EnumSource.Mode.EXCLUDE, names = {"SECONDS", "MINUTES"})
    void testTimeUnitExcludingSecondsAndMinutes(TimeUnit unit) {
        assertFalse(EnumSet.of(TimeUnit.SECONDS, TimeUnit.MINUTES).contains(unit));
        assertTrue(EnumSet
                .of(TimeUnit.DAYS, TimeUnit.HOURS, TimeUnit.MILLISECONDS, TimeUnit.NANOSECONDS,
                        TimeUnit.MICROSECONDS).contains(unit));
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, mode = EnumSource.Mode.MATCH_ALL, names = ".*SECONDS")
    void testTimeUnitIncludingAllTypesOfSecond(TimeUnit unit) {
        assertFalse(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS, TimeUnit.MINUTES).contains(unit));
        assertTrue(EnumSet
                .of(TimeUnit.SECONDS, TimeUnit.MILLISECONDS, TimeUnit.NANOSECONDS,
                        TimeUnit.MICROSECONDS).contains(unit));
    }

}