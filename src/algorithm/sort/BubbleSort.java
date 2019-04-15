package algorithm.sort;

/**
 *  冒泡排序
 *
 *  属于交换排序，稳定性好
 *
 *  时间复杂度 O(n^2)
 *
 *  空间复杂度 O(1) 用于保存temp
 *
 */
public class BubbleSort {

    public static void sort(int[] array){
        int length=array.length;
        for(int i=0;i<length-1;i++){
            // 本次循环过程中是否进行过交换
            boolean swapped=false;
            for(int j=0;j<length-i-1;j++){
                if(array[j]<array[j+1]){
                    swapped=true;
                    swap(array, j, j + 1);
                }
            }
            // 没有则说明数组有序不需要再进行排序
            if(!swapped)
                break;
        }
    }


    /**
     * 交换两个元素
     */
    private static void swap(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
