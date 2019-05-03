package dataStructure.heap;

/**
 * 最大堆
 * 基于数组实现
 */
public class MaxHeap<E extends  Comparable<? extends E>> {


    private Object[] heap;
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
        size=0;
    }


    /**
     * 求父节点的下标
     * @param pos 节点下标
     * @return 父节点下标
     */
    public int parent(int pos){
        return pos/2;
    }


    public int left(int pos){
        return 2*pos;
    }

    public int right(int pos){
        return 2*pos+1;
    }



    public void extractMax(){

    }

    public void insert(E element){
        heap[size++]=element;

    }

    public void build(){

    }

    public void maxHeapify(){

    }
}
