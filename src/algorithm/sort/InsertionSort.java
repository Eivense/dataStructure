package algorithm.sort;

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

            // 如果当前数据比前一位数据大，则开始找到当前数据应该放的位置
            while(array[i-1]>temp){
                array[i]=array[i-1];
                i--;
            }
            // 把当前数据放到合适位置
            array[i]=temp;
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
