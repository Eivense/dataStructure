package algorithm.sort;


import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 *
 * 属于交换排序，稳定性不好
 *
 * 时间复杂度 O(nlog2n)
 *
 */
public class QuickSort {


    // 递归
    public static void sort(int[] array,int p,int r){
        if(p>=r)
            return;

        // 对array[p...r]进行原址重排
//        int q = partition(array,p,r);
        int q = partition2Ways(array, p, r);
        // 对array[p...q-1]进行排序
        sort(array,p,q-1);
        // 对array[q+1...r]进行排序
        sort(array,q+1,r);
    }

    private static int partition(int[] array,int p ,int r){

        // 选择数组最后一个元素作为主元
        int q=array[r];

        // i保存当前小于主元的元素的位置
        int i=p-1;
        for(int j=p;j<r;j++){
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
     * 随机快速排序
     *
     * 每次随机选择主元，对数组的划分可以更加均衡
     */
    private static int random_partition(int[] array,int p,int r){
        Random random = new Random();
        // 生成在p到r之间的随机数
        int q=random.nextInt(r-p+1)+p;

        // q为随机选择出来的主元交换到最后一个
        swap(array,q,r);

        return partition(array,p,r);
    }


    /**
     * 双路快排
     */
    private static int partition2Ways(int[] array,int p,int r){

        // 选择数组最后一个元素作为主元
        int q=array[r];

        // 保存小于主元的元素的位置
        int i=p;
        // 保存大于主元的元素的位置
        int j=r-1;

        while(true){
            // i保存当前小于主元的元素的位置
            while (i <= r-1 && array[i] < q) {
                i++;
            }
            // j保存当前大于主元的元素的位置
            while (j >= p && array[j] > q) {
                j--;
            }

            if(i>j)
                break;

            // 交换i,j
            swap(array,i,j);
            i++;
            j--;
        }
        // i>q 把主元放到准确位置
        swap(array,i,r);

        // 返回主元的下标
        return i;
    }

    /**
     * 三路快排
     */
    private static void sort3Ways(int[] array,int p,int r){
        // 选择数组最后一个元素作为主元
        int q=array[r];

        int lt=p; // array[p...lt] < q
        int gt=r-1; // array[gt...r-1] > q
        int i=p; // array[lt+1...i) = q

        while( i < gt ){
            if( array[i] < q){
                swap( array, i, lt+1);
                i ++;
                lt ++;
            }
            else if( array[i] > q ){
                swap( array, i, gt-1);
                gt --;
            }
            else{ // arr[i] == v
                i ++;
            }
        }
        swap( array,p, lt );

        sort(array, p, lt - 1);
        sort(array, gt, r);
    }

    /**
     * 交换两个元素
     */
    private static void swap(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }


    public static void main(String[] args) {
        int[] a={4,2,17,5,12,4,8,3,15};
        sort3Ways(a,0,a.length-1);
        System.out.println(Arrays.toString(a));

    }

}
