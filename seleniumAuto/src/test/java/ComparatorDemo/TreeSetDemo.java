package ComparatorDemo;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/8/008 14:34
 * @Version: 1.0
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Student> ts=  new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                //this.age - s.age
                //比较年纪
                int num=s1.getAge()-s2.getAge();
                //年龄相同时，按照姓名的字母顺序排序
                int num2 = num == 0 ? s1.getName().compareTo(s2.getName()) : num;
                return num2;
            }
        });

        //创建学生对象
        Student s1 = new Student("xishi", 29);
        Student s2 = new Student("wangzhaojun", 28);
        Student s3 = new Student("diaochan", 30);
        Student s4 = new Student("yangyuhuan", 33);

        Student s5 = new Student("linqingxia",33);
        Student s6 = new Student("linqingxia",33);

        //把学生添加到集合
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);

        //遍历集合
        for (Student s : ts) {
            System.out.println(s.getName() + "," + s.getAge());
        }
    }
}
