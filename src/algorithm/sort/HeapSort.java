package algorithm.sort;

import dataStructure.heap.Heap;

import java.util.Comparator;

/**
 * 堆排序
 */
public class HeapSort {

    public static void sort(Integer[] array){
        // 从小到大排序 需要最大堆
        Heap heap=new Heap(array, (Comparator<Integer>) (o1, o2) -> o2.compareTo(o1));
        heap.heapSort();

        System.out.println(heap);

    }

    public static void main(String[] args) {

        Integer[] array={4,1,3,2,16,9,10,14,8,7};
        sort(array);
    }
}
