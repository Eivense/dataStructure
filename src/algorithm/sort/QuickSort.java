package algorithm.sort;


/**
 * 快速排序
 */
public class QuickSort {

    // 非递归
    public static void sort(){

    }


    // 递归
    public static void sort(int[] array,int p,int r){
        if(p<r)
            return;

        // 对array[p...r]进行原址重排
        int q = partition(array,p,r);

        // 对array[p...q-1]进行排序
        sort(array,p,q-1);
        // 对array[q+1...r]进行排序
        sort(array,q+1,r);
    }

    private static int partition(int[] array,int p ,int r){
        return 0;
    }


}
