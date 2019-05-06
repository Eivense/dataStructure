package dataStructure.heap;

import java.util.Comparator;

/**
 * 优先队列
 * 默认为最小堆
 */
public class Heap<E extends  Comparable<? super E>> {


    private Object[] heap;

    // 堆中元素个数
    private int size;

    // 比较器
    private final Comparator<? super E> comparator;

    private static final int DEFAULT_CAPACITY=10;

    public Heap() {
        this(DEFAULT_CAPACITY,null);
    }

    public Heap(int capacity, Comparator<? super E> comparator){
        heap = new Object[capacity];
        this.comparator=comparator;
    }

    public Heap(E[] elements){
       this(elements,null);
    }

    public Heap(E[] elements, Comparator<? super E> comparator){
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
            siftDown(i, size,(E) heap[i]);
        }
    }


    // 使得以pos为根节点的子树满足推的性质
    private void siftDown(int pos,int size, E element) {
        if(comparator!=null){
            // 使用比较器
            siftDownUsingComparator(pos,size,element);
        }else{
            // 直接使用Comparable接口
            siftDownComparable(pos, size,element);
        }
    }

    /**
     * 向下调整 通过Comparator比较器
     * @param pos 调整的位置
     * @param size 堆的范围
     * @param element 插入的元素
     */
    @SuppressWarnings("unchecked")
    private void siftDownUsingComparator(int pos,int size, E element) {
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
     * @param size 堆的范围
     * @param element 插入的元素
     */
    @SuppressWarnings("unchecked")
    private void siftDownComparable(int pos, int size,E element){

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
                // 保存当前最小的节点
                c=heap[child=right];
            }

            // 如果父节点比子节点大则向下调整父节点
            if(element.compareTo((E)c)>0){
                heap[pos]=c;
                // 交换父节点和子节点swap(heap,pos,child)
                // 继续向下调整
                pos=child;
            }else{
                break;
            }
        }

        // 把element放到准确位置
        heap[pos]=element;
    }



    public void siftUp(int pos,E element){
        if(comparator!=null){
            // 使用比较器
            siftUpUsingComparator(pos,element);
        }else{
            // 直接使用Comparable接口
            siftUpComparable(pos, element);
        }
    }

    @SuppressWarnings("unchecked")
    private void siftUpUsingComparator(int pos, E element) {
        while (pos > 0) {
            int parent = (pos - 1) >> 1;
            Object p = heap[parent];

            // element < parent
            if (comparator.compare(element,(E)p)<0){
                heap[pos] = p;
                pos = parent;
                // swap(heap,pos,parent)
            }
            else{
                break;
            }
        }
        heap[pos] = element;

    }


    /**
     * 从下向上调整
     *
     * 每次调整的都是叶子节点
     */
    @SuppressWarnings("unchecked")
    private void  siftUpComparable(int pos,E element){

        // 从叶子节点开始往上调整 路径上的每个父节点都要调整
        while (pos > 0) {
            // pos节点的父节点下标
            int parent = (pos - 1) >> 1;

            Object p = heap[parent];

            // 如果pos位置的元素比他的父节点要小 则交换父节点和子节点
            if (element.compareTo((E) p) < 0){
                heap[pos] = p;
                pos = parent;
                // swap(heap,pos,parent)
            }
            // 如果pos位置的元素大于等于父节点则直接退出循环
            else{
                break;
            }
        }
        // 把element放到准确位置
        heap[pos] = element;
    }


    /**
     * 堆排序
     *
     * 先建立一个最大堆
     */
    public void heapSort(){
        for(int i=size-1;i>=0;i--){
            // 堆顶为最大值 往后交换
            swap(heap, 0, i);
            // 对heap[0...i]重新建立最大堆
            // 因为只需要堆顶为最大值 所以只需要对堆顶进行调整
            siftDown(0,i,(E)heap[0]);
        }
    }


    private static void swap(Object[] array,int i,int j){
        Object temp=array[i];
        array[i]=array[j];
        array[j]=temp;
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

        Heap heap=new Heap(test, (Comparator<Integer>) (o1, o2) -> o2.compareTo(o1));
//        Heap heap=new Heap(test);

        System.out.println(heap);

    }

}
