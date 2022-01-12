package LeetCode4;

import java.util.Arrays;

/**
 * Created by LiDongZhou on 2022/1/12.
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //合并数组
        int[] arr = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            arr[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            arr[nums1.length + i] = nums2[i];
        }
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr.length == 2) {
            return (double) (((double) arr[0] + (double) arr[1]) / 2);
        }

        mergeSort(arr, 0, arr.length - 1);

        int mid = (int) Math.floor(arr.length / 2);
        if (arr.length % 2 == 0) {
            return (double) (((double) arr[mid] + (double) arr[mid - 1]) / 2);
        } else {
            return arr[mid];
        }
    }

    //归并排序
    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, mid, l, r);
    }

    public void merge(int[] nums, int mid, int l, int r) {
        int[] temp = Arrays.copyOfRange(nums, l, r + 1);
        int i = l, j = mid + 1;
        //变动的区间
        for (int k = l; k <= r; k++) {
            //如果左侧大于中间值的时候 证明左侧已经没有元素和右侧元素进行比较 则将右侧所有元素放入到数组中
            if (i > mid) {
                nums[k] = temp[j - l];
                j++;
            }
            //如果中间值大于右侧边界 则增明右侧已经没有需要和左侧进行对比的数据 则将左侧所有元素放入到数组中
            else if (j > r) {
                nums[k] = temp[i - l];
                i++;
            } else if (temp[i - l] <= temp[j - l]) {
                nums[k] = temp[i - l];
                i++;
            } else {
                nums[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //插入排序
//    public void insertionSort(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            //假定的最小值
//            int t = nums[i];
//            int j;
//            for (j = i; j - 1 >= 0 && t < nums[j - 1]; j--) {
//                nums[j] = nums[j - 1];
//            }
//            nums[j] = t;
//        }
//    }

    //选择排序
//    public void selectionSort(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            //假设当前值为最大值
//            //int temp = nums[i];
//            int maxIndex = i;
//            for (int j = i; j < nums.length - 1; j++) {
//                //如果假设最大值大于后一个值 则进行替换
//                if (nums[maxIndex] > nums[j + 1]) {
//                    swap(nums, maxIndex, j + 1);
//                    maxIndex = j + 1;
//                }
//            }
//        }
//    }


}
