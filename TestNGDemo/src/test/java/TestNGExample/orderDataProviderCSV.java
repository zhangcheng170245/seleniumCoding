package TestNGExample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangcheng
 * @Description: 数据驱动csv
 * @Date: 2021/3/9/009 17:50
 * @Version: 1.0
 */
public class orderDataProviderCSV {
    @DataProvider(name = "putInList")
    public Object[][] putInList() throws IOException {
        return getTestData("/src/main/resources/data/input_list.csv");
    }

    public static Object[][] getTestData(String fileName) throws IOException {
        String projectRoot = new File("").getAbsolutePath();
        List<Object[]> records = new ArrayList<Object[]>();
        String record;
        //设置字符集为GBK
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(projectRoot + fileName), "GBK"));
        //忽略CSV文件的标题行（第一行）
        String string = file.readLine();
        //遍历读取文件中除第一行外的其它所有行内容，并存储在名为records的ArrayList中，每一个records中存储的对象为一个string数组；
        while ((record = file.readLine()) != null) {
            String fields[] = record.split(",");
            records.add(fields);
        }
        //关闭文件
        file.close();
        //定义函数返回值Object[][],将list转换为一个Object的二维数组；
        Object[][] results = new Object[records.size()][];
        //设置二维数组每行的值，每行是一个Object对象
        for (int i = 0; i < records.size(); i++) {
            results[i] = records.get(i);
        }
        return results;
    }

    @Test(dataProvider = "putInList")
    public void putInA(String pakageName, String aNum, String bNum, String cNum, String dNum, String eNum) throws Exception {
        System.out.print("忧伤哥 操作" + pakageName + " 装入坚果A " + aNum + " 个！\n");
        Thread.sleep(100);
        System.out.print("炫酷哥 操作" + pakageName + " 装入坚果B " + bNum + " 个！\n");
        Thread.sleep(100);
        System.out.print("羞涩哥 操作" + pakageName + " 装入坚果C " + cNum + " 个！\n");
        Thread.sleep(100);
        System.out.print("暴怒哥 操作" + pakageName + " 装入坚果D " + dNum + " 个！\n");
        Thread.sleep(100);
        System.out.print("傻笑哥 操作" + pakageName + " 装入坚果E " + eNum + " 个！\n");
        Thread.sleep(100);
    }
}
