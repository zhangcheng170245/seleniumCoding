import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zz.app.page.ContactPage;
import com.zz.app.page.HomePage;
import com.zz.app.po.User;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/15/015 16:57
 * @Version: 1.0
 */
public class WxTest {
    @ParameterizedTest
    @MethodSource("initMember")
    @Order(1)
    public void testAddMember(String userName, String userPhone){
        HomePage homePage = new HomePage();
        ContactPage contactPage = homePage.contactPage().addMember(userName, userPhone);
        assertEquals(contactPage.getToast(), "添加成功");
    }
    //参数化
    public static Stream<Arguments> initMember(){
        return  Stream.of(
                Arguments.of("zcccd", "13900001003"),
                Arguments.of("zc2cd", "13900001203"));
    }

    // 通过读取json文件的形式参数化========
    @ParameterizedTest
    @MethodSource
    public void testAddMemberForJson(User user) {
        HomePage homePage = new HomePage();
        ContactPage contactPage = homePage.contactPage().addMember(user.userName, user.userPhone);
        assertEquals(contactPage.getToast(), "添加成功");
    }
    // 通过反序化，将json映射到实体类
    static List<User> testAddMemberForJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference typeReference = new TypeReference<List<User>>() {
        };
        // 读取json
        List<User> users = mapper.readValue(WxTest.class.getResourceAsStream("/user.json"), typeReference);
        return users;
    }

    // 通过读取yaml文件的形式参数化========
    @ParameterizedTest
    @MethodSource
    public void testAddMemberForYaml(User user) {
        HomePage homePage = new HomePage();
        ContactPage contactPage = homePage.contactPage().addMember(user.userName, user.userPhone);
        assertEquals(contactPage.getToast(), "添加成功");
    }
    // 通过反序化，将json映射到实体类
    static List<User> testAddMemberForYaml() throws IOException {
        //创建objmapper  jackson序列化与反
        ObjectMapper mapper = new ObjectMapper();
        TypeReference typeReference = new TypeReference<List<User>>() {
        };
        // 读取json
        List<User> users = mapper.readValue(WxTest.class
                .getResourceAsStream("/user.yaml"), typeReference);
        return users;
    }








    //=================================================

    // 通过csv 方式参数化
    @ParameterizedTest
    @CsvFileSource(resources = {"user.csv"} ,numLinesToSkip = 1)
    public void testAddMemberForcsv(String userName, String userPhone){
        HomePage homePage = new HomePage();
        ContactPage contactPage = homePage.contactPage().addMember(userName, userPhone);
        assertEquals(contactPage.getToast(), "添加成功");
    }



    @ParameterizedTest
    @ValueSource(strings = {"ceshi003", "ceshi004"})
    @Order(2)
    public void testSearchEditMember(String searchName){
        HomePage homePage = new HomePage();
        homePage.contactPage().searchEditMember(searchName);
    }

    //读取yaml参数化的方式 参数化编辑页面
    @ParameterizedTest
    @CsvFileSource(resources = {"user.csv"} ,numLinesToSkip = 1)
    public void testSearchEditMember1(String n1,int n2){
        HomePage homePage = new HomePage();
        homePage.contactPage().searchEditMember(n1);
    }


    @ParameterizedTest
    @ValueSource(strings = {"ceshi003", "ceshi004"})
    @Order(3)
    public void testSearchDeleteMember(String searchName){
        HomePage homePage = new HomePage();
        homePage.contactPage().deleteMember(searchName);
    }






}
