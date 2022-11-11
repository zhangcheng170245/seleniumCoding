package letcode;

import java.util.Arrays;

/**
 * @ProjectName: seleniumCoding
 * @Package: letcode
 * @ClassName: copyOFdemo
 * @Author: 还是那个橙子
 * @Description:
 * @Date: 2022/11/11 17:18
 * @Version: 1.0
 */

public class copyOFdemo { public static void main(String[] args) {
    int [] a={11,22,33,44,55},b,c,d;
    // a.length=5;
    // 反转3
    System.out.println("数组a中各元素的值为:");
    System.out.println(Arrays.toString(a));
    b=Arrays.copyOf(a,8);
    System.out.println("数组b中各元素的值为:");
    System.out.println(Arrays.toString(b));
    c=Arrays.copyOfRange(a,0,4);
    System.out.println("数组c中各元素的值为:");
    System.out.println(Arrays.toString(c));
    d=Arrays.copyOfRange(a,3,5);  // 从a[3]开始，a[5] 结束
    System.out.println("数组d中各元素的值为:");
    System.out.println(Arrays.toString(d));

    System.arraycopy(a, 0, a, 3, a.length - 3);
    System.arraycopy(d, 0, a, 0, 3);

    System.out.println(Arrays.toString(a));


}


}
