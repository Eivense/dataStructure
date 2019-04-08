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
    private void doubleCapacity(){}


    @Override
    public void addLast(E e) {
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
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

}
