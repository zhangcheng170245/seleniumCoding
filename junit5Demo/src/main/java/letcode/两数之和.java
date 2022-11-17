package letcode;

import java.util.HashMap;

/**
 * @ProjectName: seleniumCoding
 * @Package: letcode
 * @ClassName: 两数之和
 * @Author: 还是那个橙子
 * @Description:
 * @Date: 2022/11/16 20:41
 * @Version: 1.0
 */

public class 两数之和 {
    public static void main(String[] args) {

    }

    // b遍历放入map   键值对，键位不能重复 ，kv 可以为空
    public static int[] twonum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                res[1] = i;
                res[0] = map.get(tmp);
            }
            map.put(nums[i], i);
        }
        return res;
    }

    // bao暴力破解
    public static int[] twoSum2(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++)
            for(int j=i+1;j<nums.length;j++)
                if(nums[i]+nums[j]==target)
                    return new int[] {i,j};
        return new int[] {};
    }
}
