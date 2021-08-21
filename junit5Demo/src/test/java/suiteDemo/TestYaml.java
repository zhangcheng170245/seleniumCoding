package suiteDemo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author: zhangcheng
 * @Description: 测试读取yaml字段
 * @Date: 2021/3/10/010 11:42
 * @Version: 1.0
 */
public class TestYaml {

    @ParameterizedTest() //参数化注解
    @MethodSource("testDDTFromYaml") //指定名字来同名的测试方法
    public void testDDTFromYaml(User user) {
        assertTrue(user.name.length() > 4);

    }
    static Object testDDTFromYaml() throws IOException {
        //创建objmapper  jackson序列化与反
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        //ji
        TypeReference typeReference = new TypeReference<List<User>>() {
        };
        //读取useryaml 反序列化为类
        Object users = mapper.readValue(
                TestYaml.class.getResourceAsStream("/user.yaml"),typeReference
        );
        return users;
    }
}
