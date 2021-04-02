package suiteDemo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/10/010 13:37
 * @Version: 1.0
 */
public class TestYamlJson {


    @ParameterizedTest
    @MethodSource
    public void testDDTFromJson(User user) {
        assertTrue(user.name.length() > 3);

    }
    static List<User> testDDTFromJson() throws IOException {
        //创建objmapper 去掉new YAMLFactory()
        ObjectMapper mapper = new ObjectMapper();
        TypeReference typeReference = new TypeReference<List<User>>() {
        };
        //读取user.json
        List<User> users = mapper.readValue(
                TestYaml.class.getResourceAsStream("/user.json"),typeReference
        );
        return users;
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"user.csv"} ,numLinesToSkip = 1)
    public void parameterizedCsvFileSourceTest(int n1,int n2){
        System.out.println(n1);
        System.out.println(n2);
    }


}
