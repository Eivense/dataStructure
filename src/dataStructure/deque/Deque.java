package dataStructure.deque;

/**
 * 双端队列接口
 * @param <E>
 *
 * 所有方法失败抛出异常
 *
 * 抛出异常       返回null
 * addFirst       offerFirst
 * addLast        offerLast
 * removeFirst    pollFirst
 * removeLast     pollLast
 * getFirst       peekFirst
 * getLast        peekLast
 */
public interface Deque<E> {


    /**
     * 往队尾添加节点
     * @param e 添加的节点
     */
    void addLast(E e);


    /**
     * 往队首添加节点
     * @param e 添加的节点
     */
    void addFirst(E e);


    /**
     * 删除队首节点，并返回被删除的节点
     * @return 返回被删除的节点
     */
    E removeFirst();


    /**
     * 删除队尾节点，并返回被删除的节点
     * @return 返回被删除的节点
     */
    E removeLast();


    /**
     * 获取并返回队首节点
     * @return 返回头节点
     */
    E getFirst();

    /**
     * 获取并返回队尾节点
     * @return 返回尾节点
     */
    E getLast();
}
