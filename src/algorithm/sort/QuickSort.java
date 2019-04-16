package algorithm.sort;


/**
 * 快速排序
 *
 * 属于交换排序，稳定性不好
 *
 * 时间复杂度 O(nlog2n)
 *
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

        // q为主元
        int q=array[r];

        // i保存当前小于主元的元素的位置
        int i=p-1;
        for(int j=p;j<r-1;j++){
            if(array[j]<=q){
                i++;
                swap(array,i,j);
            }
        }

        // 交换主元 使得主元在准确位置
        swap(array,i+1,r);

        // 返回主元下标
        return i+1;
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
