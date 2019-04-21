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
    public static void sort(int[] array,int left,int right){
        if(left>=right)
            return;

        // 对array[p...r]进行原址重排
//        int pivot = partition(array,p,r);
        int pivot = partition3Ways(array, left, right);
        // 对array[p...pivot-1]进行排序
        sort(array,left,pivot-1);
        // 对array[pivot+1...r]进行排序
        sort(array,pivot+1,right);
    }

    private static int partition(int[] array,int left ,int right){

        // 选择数组最后一个元素作为主元
        int pivot=array[right];

        // i保存当前小于主元的元素的位置
        int i=left-1;
        for(int j=left;j<right;j++){
            if(array[j]<=pivot){
                i++;
                // 交换ij
                swap(array,i,j);
            }
        }

        // 交换主元 使得主元在准确位置
        swap(array,i+1,right);

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
    private static int partition2Ways(int[] array,int left,int right){

        // 选择数组最后一个元素作为主元
        int pivot=array[right];

        // 保存小于主元的元素的位置
        int i=left;
        // 保存大于主元的元素的位置
        int j=right-1;

        while(true){
            // i保存当前小于主元的元素的位置
            while (i <= right-1 && array[i] < pivot) {
                i++;
            }
            // j保存当前大于主元的元素的位置
            while (j >= left && array[j] > pivot) {
                j--;
            }

            // 当i>j的时候 说明当前数组已经重排完成
            if(i>j) {
                break;
            }
            // 交换i,j
            swap(array,i,j);
            i++;
            j--;
        }
        // 把主元放到准确位置
        swap(array,i,right);

        // 返回主元的下标
        return i;
    }

    /**
     * 三路快排
     */
    private static int partition3Ways(int[] array,int left,int right){
        // 选择数组最后一个元素作为主元
        int pivot=array[right];

        int small=left-1; // array[left...small] < pivot
        int large=right;  // array[large...right-1] > pivot
        int i=left; // array[small...i) = pivot

        while(i<large){
            if(array[i]<pivot){
                swap(array, i, small + 1);
                small++;
                i++;
            }else if(array[i]>pivot){
                // 讲array[i]换到大于pivot的区间里
                // 但是由于不知道换过来的元素应该属于哪个区间所以i不增加，下一次循环再进行判断
                swap(array, i, large - 1);
                large--;
            }else{ // array[i]==pivot
                i++;
            }
        }

        // 把主元放到准确位置
        swap(array,i,right);

        return i;
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
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));

    }

}
