package LeetCode1;

import java.util.Arrays;

/**
 * Created by LiDongZhou on 2022/1/10.
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            add(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int absTarget = target - nums[i];
            if (target < 0 && nums[i] < 0) {
                absTarget = 0 - (Math.abs(target) - Math.abs(nums[i]));
            } else if (target < 0 || nums[i] < 0) {
                absTarget = 0 - (Math.abs(target) + Math.abs(nums[i]));
            }
            int resIndex = contains(absTarget, i);
            if (resIndex != -1) {
                res[0] = i;
                res[1] = resIndex;
                break;
            }
        }
        return res;
    }

    //二分搜索的基本条件是有序的 当前案例不符合
//    public int getIndex(int[] nums, int l, int r, int target, int cur) {
//        if (l > r) {
//            return -1;
//        }
//        int mid = l + (r - l) / 2;
//        if (mid == cur) {
//            return getIndex(nums, mid + 1, r, target, cur);
//        }
//        if (nums[mid] < target) {
//            return getIndex(nums, mid + 1, r, target, cur);
//        } else if (nums[mid] > target) {
//            return getIndex(nums, l, mid - 1, target, cur);
//        } else {
//            return mid;
//        }
//    }
    //使用二分搜索树进行搜索
    private class Node {
        public int e;
        public int index;
        public Node left, right;

        public Node(int e, int index) {
            this.index = index;
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root = null;

    public void add(int e, int index) {
        root = add(root, e, index);
    }

    public Node add(Node node, int e, int index) {
        if (node == null) {
            return new Node(e, index);
        }
        if (e < node.e) {
            node.left = add(node.left, e, index);
        } else {
            node.right = add(node.right, e, index);
        }
        return node;
    }

    public int contains(int target, int index) {
        Node node = contains(root, target, index);
        if (node == null) {
            return -1;
        }
        return node.index;
    }

    public Node contains(Node node, int target, int index) {
        if (node == null) {
            return null;
        }
        if (node.e == target && node.index != index) {
            return node;
        } else if (node.e < target) {
            return contains(node.right, target, index);
        } else {
            return contains(node.left, target, index);
        }
    }
}
