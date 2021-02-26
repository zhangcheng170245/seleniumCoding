package com.datatest;

import java.util.Arrays;

/**
 * @Author: zhangcheng
 * @Description: 冒泡排序
 * @Date: 2021/2/26 17:26
 * @Version: 1.0
 */
public class BubbleSortMain {
    public static void main(String[] args) {
        Integer[] arr = {2,5,1,3,8,5,7,4,3};
        System.out.println(Arrays.deepToString(arr));  // 排序前
        sortBubble(arr);
        System.out.println(Arrays.deepToString(arr)); // 排序后
    }

    // 冒泡方法
    private static void sortBubble(Integer[] arr) {
        if (arr==null||arr.length<2){
            return;
        }

        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    int temp= arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
