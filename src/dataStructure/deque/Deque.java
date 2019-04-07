package dataStructure.deque;

/**
 * 双端队列接口
 * @param <E>
 *
 *
 */
public interface Deque<E> {


    /**
     * 往尾添加节点
     *
     * 抛出异常
     *
     * @param e
     */
    void addLast(E e);


    /**
     * 往头添加节点
     *
     * 抛出异常
     *
     * @param e
     */
    void addFirst(E e);

    E removeFirst();

    E removeLast();

    E peekFirst();

    E peekLast();
}
