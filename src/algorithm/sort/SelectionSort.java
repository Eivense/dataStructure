package algorithm.sort;

/**
 * 简单选择排序
 *
 * 属于选择排序，不稳定
 *
 * 时间复杂度 O(n^2)
 *
 */
public class SelectionSort {

    public static void sort(int array[]){
        for(int i=0;i<array.length;i++){
            int min=i;
            // 选择出最小的元素
            for(int j=i+1;j<array.length;j++){
                if(array[j]>array[min]){
                    // 记录最小元素的下标
                    min=j;
                }
            }
            // 把最小的元素与i交换
            swap(array,i,min);
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
