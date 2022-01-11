package LeetCode1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LiDongZhou on 2022/1/12.
 * 哈希表优化 不先对整个哈希进行put 在找不到时再进行映射 节省空间同时减少耗时
 * 例[3,3]这样的数据 通过原因为第一遍哈希get时 哈希表中还没有进行存储 所以查找不到 只有在第二遍查找时才会进行查询 同时此刻第二个3还未插入 所以找到的是第一个3
 */
public class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //O(n)
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
        //o(n)
        for (int i = 0; i < nums.length; i++) {
            int nl = target - nums[i];
            //O(1)
            if (map.containsKey(nl)) {
                return new int[]{i, map.get(nl)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
