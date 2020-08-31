/*
package test;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

*/
/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/8/28 20:25
 * @Description:
 *//*

public class TestSelenum2 {

    WebDriver driver;

    @Test
    public void testSelenium() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        //利用chromedriver控制chrome
        driver = new ChromeDriver();
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    public void loadCookie(WebDriver driver){
        try {
            FileReader fileReader = new FileReader("cookie.txt");
            // 读取内容
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            //读取内容依次处理
            while ((line=bufferedReader.readLine())!=null){
                //分词器 对行进行分词操作  指定分号进行分词
                StringTokenizer tokenizer = new StringTokenizer(line,";");
                String name = tokenizer.nextToken();
                String value = tokenizer.nextToken();
                String domain = tokenizer.nextToken();
                String path = tokenizer.nextToken();
                Date expiry = null;
                String dt = tokenizer.nextToken();
                if (!dt.equals("null")){
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                    //把 string 转换成 date
                    expiry = sdf.parse(dt);
                }

                //把 string 转换成 boolean
                boolean isSecure = Boolean.parseBoolean(tokenizer.nextToken());
                Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
                driver.manage().addCookie(cookie);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void saveCookie(WebDriver driver) {
        //文件输入流
        // 缓冲流
        try {
            FileWriter writer = new FileWriter("cookie.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

        for (Cookie cookie : driver.manage().getCookies()) {
                //保存.
                bufferedWriter.write(cookie.getName() + ';' +
                        cookie.getValue() + ";" +
                        cookie.getDomain() + ";" +
                        cookie.getPath() + ";" +
                        cookie.getExpiry() + ";" +
                        cookie.isSecure());
                // 保存到下一行
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
                e.printStackTrace();
        }

        }

}*/
