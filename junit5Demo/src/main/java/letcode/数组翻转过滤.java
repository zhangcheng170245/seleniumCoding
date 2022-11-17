package letcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @ProjectName: seleniumCoding
 * @Package: letcode
 * @ClassName: 数组翻转过滤
 * @Author: 还是那个橙子
 * @Description:
 * @Date: 2022/11/17 14:58
 * @Version: 1.0
 */

public class 数组翻转过滤 {
    public static void main(String[] args) {
        int[] str = {2, 3, 4, 6, 3, 5};
        resever2(str);
        System.out.println();

    }

    // 方式1
    public static void resever(int[] str){
        //使用临时数组
        int[] temp = new int[str.length];
        //把原数组的内容反转后赋值给数组temp
        for (int i=0;i<str.length;i++) {
            temp[i] = str[str.length-i-1];
        }
        //ArrayList 去重 过滤
        ArrayList<Integer> list = new ArrayList<>();
        //由于要求是对原数组array实现反转效果，所以再把temp挨个赋值给array
        for (int i=0;i<temp.length;i++) {
            str[i] = temp[i];
            if (!list.contains(str[i])) {
                list.add(str[i]);
                System.out.print(str[i]+" ");
            }
        }
    }

    // Collections 反转  // 遍历
    public static void resever2(int[] str) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < str.length; i++) {
            if (!arrayList.contains(str[i])) {
                arrayList.add(str[i]);
                System.out.print(str[i]+" ");
            }
            Collections.reverse(arrayList);
            }
        }
    }
