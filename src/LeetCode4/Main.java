package LeetCode4;

/**
 * Created by LiDongZhou on 2022/1/12.
 */
public class Main {
    public static void main(String[] args) {
        int[] a = {3, 4, 6, 1, 2, 5};
        int[] b = {};
        findMedianSortedArrays fm = new findMedianSortedArrays();
        System.out.println(fm.findMedianSortedArrays(a, b));
    }
}
