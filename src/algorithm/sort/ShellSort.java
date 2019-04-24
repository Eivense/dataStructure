package algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序（缩小增量排序）
 *
 * 属于插入排序
 *
 * 时间复杂度O(nlog2n)
 */
public class ShellSort {

    public static void sort(int[] array) {
        int n = array.length;
        // 步长为d
        int d = n / 2;
        while (d > 0) {
            for (int i = d; i < n; i++) {
                int temp = array[i];
                int j = i;
                while (j >= d && array[j - d] > temp) {
                    array[j] = array[j - d];
                    j = j - d;
                }
                array[j] = temp;
            }
            d = d / 2;
        }
    }


    public static void main(String[] args) {
        int[] a={4,2,17,5,12,4,8,3,15};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
