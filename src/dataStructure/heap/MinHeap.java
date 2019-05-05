package dataStructure.heap;

import java.util.Comparator;

/**
 * 最小堆
 * 基于数组实现
 */
public class MinHeap<E extends  Comparable<? super E>> {


    private Object[] heap;

    // 堆中元素个数
    private int size;

    // 比较器
    private final Comparator<? super E> comparator;

    private static final int DEFAULT_CAPACITY=10;

    public MinHeap() {
        this(DEFAULT_CAPACITY,null);
    }

    public MinHeap(int capacity, Comparator<? super E> comparator){
        heap = new Object[capacity];
        this.comparator=comparator;
    }

    public MinHeap(E[] elements){
       this(elements,null);
    }

    public MinHeap(E[] elements,Comparator<? super E> comparator){
        size=elements.length;
        heap=elements;
        this.comparator=comparator;
        heapify();
    }

    public void extractMax(){

    }

    public void insert(E element){
        heap[size++]=element;

    }


    /**
     * 建堆
     *
     * heap[0...i/2]为父节点
     * heap[i/2+1...n]为叶子节点
     *
     * 从最后一个叶子节点的父节点开始建堆
     */
    @SuppressWarnings("unchecked")
    public void heapify(){
        // i=size/2-1 最后一个叶子节点的父节点的下标
        for (int i = (size>>1)-1; i >= 0; i--){
            siftDown(i, (E) heap[i]);
        }
    }

    private void siftDown(int i, E e) {
        if(comparator!=null){
            // 使用比较器
            siftDownUsingComparator(i,e);
        }else{
            // 直接使用Comparable接口
            siftDownComparable(i, e);
        }
    }

    /**
     * 向下调整 通过Comparator比较器
     * @param pos 调整的位置
     * @param element 插入的元素
     */
    @SuppressWarnings("unchecked")
    private void siftDownUsingComparator(int pos, E element) {
        // heap[0..half]为父节点
        // heap[half+1...size]为叶子节点
        int half=size>>1;

        // 当不是父节点时停止 即heap[pos]为叶子节点
        while(pos<half){

            // child保存最小的子节点的下标
            int child=(pos<<1)+1;
            // child 保存最小的子节点
            Object c=heap[child];
            int right=child+1;

            // 如果左节点比右节点大 则右节点作为最小的节点
            if (right < size &&
                    comparator.compare((E) c, (E) heap[right]) > 0){
                c = heap[child = right];
            }

            // 如果父节点比子节点大则向下调整父节点
            if(comparator.compare(element,(E)c)>0){
                heap[pos]=c;
            }else{
                break;
            }
            // 继续向下调整
            pos=child;
        }

        // 直接给叶子节点赋值
        heap[pos]=element;
    }


    /**
     * 向下调整 通过Comparable接口
     * @param pos 调整的位置
     * @param element 插入的元素
     */
    @SuppressWarnings("unchecked")
    public void siftDownComparable(int pos,E element){

        Comparable<? super E> key = element;

        // heap[0..half]为父节点
        // heap[half+1...size]为叶子节点
        int half=size>>1;

        // 当不是父节点时停止 即heap[pos]为叶子节点
        while(pos<half){

            // child保存最小的子节点的下标
            int child=(pos<<1)+1;
            // child 保存最小的子节点
            Object c=heap[child];
            int right=child+1;

            // 如果左节点比右节点大 则右节点作为最小的节点
            if (right < size &&
                    ((Comparable<? super E>) c).compareTo((E) heap[right]) > 0){
                c=heap[child=right];
            }

            // 如果父节点比子节点大则向下调整父节点
            if(element.compareTo((E)c)>0){
                heap[pos]=c;
            }else{
                break;
            }
            // 继续向下调整
            pos=child;
        }

        // 直接给叶子节点赋值
        heap[pos]=key;
    }



    public void siftUp(int pos,E element){

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++)
            sb.append(heap[i] + " ");
        return new String(sb);

    }

    public static void main(String[] args) {
        Integer[] test={4,1,3,2,16,9,10,14,8,7};

        MinHeap heap=new MinHeap(test, (Comparator<Integer>) (o1, o2) -> o2.compareTo(o1));
//        MinHeap heap=new MinHeap(test);

        System.out.println(heap);

    }

}
