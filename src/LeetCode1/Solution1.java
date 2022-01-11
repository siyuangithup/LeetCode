package LeetCode1;

/**
 * Created by LiDongZhou on 2022/1/12.
 * 暴力解法 时间复杂度O(n^2)
 */
public class Solution1 {
    public int[] twoSumBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }
}
