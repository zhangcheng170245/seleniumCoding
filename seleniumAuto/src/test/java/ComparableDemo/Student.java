package ComparableDemo;

/**
 * @Author: zhangcheng
 * @Description: Comparable基于util 包实现
 * @Date: 2021/3/8/008 11:42
 * @Version: 1.0
 */

public class Student implements Comparable<Student> {
    @Override
    public int compareTo(Student s) {
//        return 0;
//        return 1;
//        return -1;
        //按照年龄从小到大排序
        int num = this.age - s.age;
//        int num = s.age - this.age;
        //年龄相同时，按照姓名的字母顺序排序
        int num2 = num == 0 ? this.name.compareTo(s.name) : num;
        return num2;
    }


    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
