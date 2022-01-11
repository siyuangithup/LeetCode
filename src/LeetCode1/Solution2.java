package LeetCode1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LiDongZhou on 2022/1/12.
 * 通过哈希表进行获取
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //O(n)
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        //o(n)
        for (int i = 0; i < nums.length; i++) {
            int nl = target - nums[i];
            //O(1)
            if (map.containsKey(nl) && i != map.get(nl)) {
                return new int[]{i, map.get(nl)};
            }
        }
        return new int[]{};
    }
}
