package dataStructure.linkedList;

/**
 * 双向链表
 * @param <E>
 */
public class DoubleLinkedList<E> implements List<E>{

    //链表头节点
    private Node<E> head;

    //链表尾节点
    private Node<E> tail;

    //链表长度
    private int size=0;

    //内部节点类
    class Node<E>{

        //数据
        E element;

        //指向下一个节点
        Node<E> next;

        //指向上一个节点
        Node<E> prev;

        Node() {
        }

        Node(E element) {
            this.element= element;
        }
    }
    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(E element) {
        Node<E> current=head;

        while(head.next!=null){
            current=head.next;
        }
        Node<E> newNode= new Node<>(element);
        current.next=newNode;
        newNode.prev=current;
        newNode.next=tail;

        size++;
    }

    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);

        Node<E> temp=head.next;
        newNode.next=temp;
        newNode.prev=head;
        head.next=newNode;

        size++;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void reverse() {

    }

    @Override
    public void display() {

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
