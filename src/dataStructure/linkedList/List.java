package dataStructure.linkedList;

/**
 * 链表接口
 * @param <E>
 */
public interface List<E> {

    //获取链表长度
    int size();

    //插入数据
    void add(E element);

    //在头插入数据
    void addFirst(E element);

    //插入数据到指定位置
    void add(int index,E element);

    //删除指定位置的数据
    void remove(int index);

    //反转
    void reverse();

    //显示
    void display();

    boolean isEmpty();
}
