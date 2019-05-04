package dataStructure.heap;

/**
 * 最大堆
 * 基于数组实现
 */
public class MaxHeap<E extends  Comparable<? super E>> {


    private Object[] heap;

    // 堆中元素个数
    private int size;

    // 堆的容量
    private int capacity;

    private static final int DEFAULT_CAPACITY=10;

    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }

    public MaxHeap(int capacity){
        heap = new Object[capacity];
        this.capacity=capacity;
    }

    public MaxHeap(E[] elements){
        size=elements.length;
        heap=elements;
        buildHeap();
    }

    public void extractMax(){

    }

    public void insert(E element){
        heap[size++]=element;

    }

    public void buildHeap(){

    }

    public void heapify(){

    }

    public void siftDown(int pos,E element){

    }

    public void siftUp(int pos,E element){

    }


}
