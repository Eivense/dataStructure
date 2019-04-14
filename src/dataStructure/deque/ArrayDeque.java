package dataStructure.deque;


/**
 * 双端队列
 *
 * 可以当作队列也可以当作栈使用
 *
 * 基于数组实现
 *
 *
 */
public class ArrayDeque<E> implements Deque<E> {


    // 由于泛型不能创建数组 只能用Object之后再强转
    // 涉及到泛型的类型擦除
    transient Object[] elements;


    //队首指针  指向队首第一个有效元素
    transient int head;

    //队尾指针  指向队尾第一个可插入的空位
    transient int tail;

    //队列中元素个数
    transient int count;


    public ArrayDeque() {
        // 默认大小为16
        elements = new Object[16];
    }


    /**
     * 扩充容量
     */
    private void doubleCapacity(){
        // 没有容量 assert会抛出AssertionError
        // assert head==tail;

        // 原数组长度
        int n=elements.length;
        // head的位置
        int p=head;
        // head 右边节点的个数
        int r=n-head;

        // 左移一位相当于乘2 扩大一倍;
        int newCapacity=n<<1;
        if(newCapacity<0){
            throw new IllegalStateException("队列太大，不能再扩展");
        }

        //  创建新的数组 容量是之前的一倍
        Object[] a=new Object[newCapacity];

        //复制head右边部分 右边部分即head到n,共r个
        System.arraycopy(elements, p, a, 0, r);
        //复制head左边部分 左边部分即0到head 共p个
        System.arraycopy(elements, 0, a, r, p);

        elements=a;
        // 新的head为0
        head=0;
        // tail为之前数组的长度
        tail=n;

    }


    @Override
    public void addLast(E e) {
        // 不允许插入为空的数据
        if(e==null)
            throw new NullPointerException();
        elements[tail]=e;

        //判断容量
        if((tail = (tail + 1) & (elements.length - 1)) == head)
            doubleCapacity();
    }

    @Override
    public void addFirst(E e) {
        if(e==null)
            throw new NullPointerException();
        elements[head=(head-1)&(elements.length-1)]=e;
        if(head==tail)
            doubleCapacity();
    }

    @Override
    public E pollFirst() {
        // 获取被删除的节点即头节点
        @SuppressWarnings("unchecked")
        E result = (E) elements[head];

        // 即队列为空
        if(result==null){
            return null;
        }
        // GC
        elements[head]=null;

        // 计算新的head位置
        head = (head + 1) & (elements.length - 1);
        return result;
    }

    @Override
    public E pollLast() {
        int t = (tail - 1) & (elements.length - 1);

        // 获取被删除的节点即尾节点
        @SuppressWarnings("unchecked")
        E result = (E) elements[t];

        // 即队列为空
        if (result == null)
            return null;

        elements[t] = null;

        tail = t;
        return result;
    }


    @Override
    @SuppressWarnings("unchecked")
    public E peekFirst() {
        return (E) elements[head];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peekLast() {
        return (E) elements[(tail - 1) & (elements.length - 1)];
    }


    public static void main(String[] args) {
        ArrayDeque test=new ArrayDeque<Integer>();
        test.addLast(1);
        test.addLast(2);
        test.addLast(3);

        System.out.println(test.pollLast());
    }


}
