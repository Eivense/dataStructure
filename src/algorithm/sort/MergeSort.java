package algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {


    public static void sort(int[] array){
        mergeSort(array,0,array.length-1);
    }

    private static void mergeSort(int[] array,int left,int right){
        if(left>=right){
            return;
        }
        int mid=(left+right)/2;
        mergeSort(array,left,mid);
        mergeSort(array,mid+1,right);
        merge(array,left,mid,right);
    }


    /**
     * 将array[left...mid]和array[mid+1...right]两部分进行归并
     */
    private static void merge(int[] array,int left,int mid,int right){

        // 复制原数组 范围是[left,right+1),即array[left...right]
        int[] temp= Arrays.copyOfRange(array,left,right+1);

        int i=left,j=mid+1;
        for(int k=left;k<=right;k++){
            // 左边元素处理完毕
            if(i>mid){
                j++;
            }
            // 右边元素处理完毕
            else if(j>right){
                i++;
            }
        }


    }
}
