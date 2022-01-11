package LeetCode1;

/**
 * Created by LiDongZhou on 2022/1/10.
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p/>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p/>
 * 你可以按任意顺序返回答案。
 */
public class Main {
    public static void main(String[] args) {
        Solution3 su = new Solution3();
        //int[] nums = new int[]{3,3};
        int[] nums = new int[]{3,3};
        su.twoSum(nums, 6);
    }

}
