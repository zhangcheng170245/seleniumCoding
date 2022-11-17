package letcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ProjectName: seleniumCoding
 * @Package: letcode
 * @ClassName: 数组翻转位数
 * @Author: 还是那个橙子
 * @Description:
 * @Date: 2022/11/11 17:17
 * @Version: 1.0
 */

public class 数组翻转 {  public static void main(String[] args) {
    int[] nums={1,2,3,4,5,6,7,7};
    reverse2(nums,-1);
    System.out.println(9%7);
    System.out.println(Arrays.toString(nums));
}

    /**
     * 数组翻转
     * @param nums 数组
     * @param K 反转位数
     */
    public static void reverse(int[] nums,int K ) {
        int len = nums.length;
        int temp[]=new int[len];
        //把原数组值放到一个临时数组中，
        for (int i = 0; i < len; i++) {
            temp[i]=nums[i];
        }
        // arraylist数据不可重复
        ArrayList<Integer> list = new ArrayList<>();
        //把临时数组的值放到原数组中
        for (int i = 0; i < len; i++) {
            nums[i]=temp[(i+K)%len];  // 通过取证

        }
    }

    public static void reverse2(int[] nums,int k ) {
        //int[] nums={1,2,3,4,5,6,7}; 3
        k = k % nums.length;
        System.out.println(k);
        //  copyOfRange(orn,int from, int to)    orn为原数组，from和to表示从from开始到to结束的位置复制到b数组中
        int[] rightpart = Arrays.copyOfRange(nums, nums.length - k, nums.length);  // 3- 7截取数组 只展示最后k个元素 567
        // 调用方法，复制源数组从索引为1的位置开始的2个元素，然后复制到目标数组从索引1开始的两个元素 567
        //从下标为0的位置开始复制，复制的长度为4(复制 1234 )，从下标为3的位置开始替换为1234
        System.arraycopy(nums, 0, nums, k, nums.length - k);  // 复制未反转的到最后k个位置
        //，复制源数组从索引为1的位置开始的2个元素，然后复制到目标数组从索引1开始的两个元素
        System.arraycopy(rightpart, 0, nums, 0, k);

    }


}
