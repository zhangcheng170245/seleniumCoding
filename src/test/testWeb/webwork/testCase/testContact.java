package webwork.testCase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_web.wework.page.ContactPage;
import test_web.wework.page.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/8/31 08:07
 * @Description:
 */
public class testContact {

     static MainPage main;
     static ContactPage contact;
    @BeforeAll
    static void beforeAll(){
        main= new MainPage();
        contact=main.toContact();
    }

    @Test
    void testAddmerber() {
        String userName = contact.addMermber("3", "3", "15600534763").search("3").getUserName();
        assertEquals(userName, "3");

    }

    @Test
    void search(){
       contact.search("3").delete();
    }


    @AfterAll
    public static void afterAll() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        contact.quit();

    }

}