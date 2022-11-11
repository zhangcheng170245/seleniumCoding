package letcode;

import java.util.HashSet;

/**
 * @ProjectName: seleniumCoding
 * @Package: letcode
 * @ClassName: 只出现一次的数字
 * @Author: 还是那个橙子
 * @Description:
 * @Date: 2022/11/11 17:19
 * @Version: 1.0
 */

public class 只出现一次的数字 { //异或解决
    public static  int singleNumber(int[] nums){
        int result=0;
        // 遍历数组
        for (int i =0;i<nums.length;i++){
            //异或运算，相异为真，相同为假
            result^=nums[i]; //因为和自己异或结果为0,相同的数字筛选后只剩下，不同数字，不同的数字和0异或 后等于其本身、
            //因为异或运算 满足交换律 a^b^a = a^a^b = b 所以数组经过异或运算，单独的值就剩下了
        }
        return result;
    }
    //SET 解决
    public static  int singleByset(int[] nums){
        HashSet<Integer> integer = new HashSet<>();
        for (int num:nums) {
            //如果添加失败，说明这个值
            //在集合Set中存在，我们要
            //把他给移除掉
            if (!integer.add(num)) {
                integer.remove(num);
            }
        }
        return (int) integer.toArray()[0];
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,2,6,23,6};
        int[] nums2={1,2,3,4,6};
        int a=1;
        //自己和自己异或 等于0
        int i = a ^ a;
        //  System.out.println(i);
        //  a^0=a；任何数字 和0异或 还等于他自己
     /*   int j= 3 ^ 0;
        System.out.println(j);*/
        //a^b^c=a^c^b；异或运算具有交换律

        System.out.println(singleByset(nums));

    }
}