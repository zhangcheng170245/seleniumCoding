package letcode;

/**
 * @ProjectName: seleniumCoding
 * @Package: letcode
 * @ClassName: 删除数组重复数据
 * @Author: 还是那个橙子
 * @Description:
 * @Date: 2022/11/11 17:14
 * @Version: 1.0
 */

public class 删除数组重复数据 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 5, 5, 7, 10, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(remove5(arr));
        System.out.println(arr);
    }

    //
    public static int remove(int[] arr) {
        int index = 0;
        // 遍历数组 从第二个数开始
        for (int left = 1; left < arr.length; left++) {
            //前后数据比对
            if (arr[left] != arr[left - 1]) {
                //如果前后两个数据重复
                index++;
            } else {
                //如果前后两个数据不重复 后面的往前面挪
                arr[left - index] = arr[left];
            }
        }
        //数组的长度减去重复的个数
        return arr.length - index;
    }

    // 双指针移除
    public static int remove2(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = 1;
        while (right < arr.length) {
            // 前一个指针的数据和第二个指针数据比对
            if (arr[left] != arr[right]) {
                arr[left + 1] = arr[right];
                left++;
            }
            right++;
        }
        return left + 1;
    }


    public static int remove4(int[] nums) {
        int j = 0;
        // 遍历数组 从第yi 个数开始
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {  //第一个数 第二个数不相等
                nums[++j] = nums[i];   //第二个数据挪到第一个数据的后面
            }
        }
        return j + 1;
    }

    public static int remove5(int nums[]) {
        // 双指针  前后指针比对
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return nums.length == 0 ? 0 : j + 1;
    }


    public static int remove6(int nums[]) {
        // 初始化一个指针
        int z = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=nums[z]){  //第一个数 第二个数不相等
                nums[++z]=nums[i];  //第二个数据挪到第一个数据的后面

            }
        }
        return z+1;
    }


}
