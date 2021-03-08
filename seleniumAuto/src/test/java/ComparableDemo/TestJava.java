package ComparableDemo;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Author: zhangcheng
 * @Description: Treeset 实现成绩大小比较
 * @Date: 2021/3/8/008 11:44
 * @Version: 1.0
 */
public class TestJava {
    public static void main(String[] args) {
        //创建集合
        TreeSet<Student> students = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //比较年纪
               int age1=o1.getAge()-o2.getAge();
               //
               int age2= age1 ==0 ? o1.getName().compareTo(o2.getName()):age1;
               return  age2;

            }
        });
    }
}
