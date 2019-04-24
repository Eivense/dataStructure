package algorithm.sort;

import java.util.Arrays;

/**
 * 简单插入排序
 *
 * 属于插入排序，稳定
 *
 * 时间复杂度O(n^2）
 */
public class InsertionSort {

    public static void sort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int temp=array[i];

            // 保存当前元素的下标
            int j = i;
            // 如果当前数据比前一位数据大，则开始找到当前数据应该放的位置
            while (j >= 1 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            // 把当前数据放到合适位置
            array[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a={4,2,17,5,12,4,8,3,15};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}

