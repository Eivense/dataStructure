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


    // 构造
    public DoubleLinkedList() {

        this.head = new Node<>();
        this.tail = new Node<>();

        //头节点指向尾节点
        head.next=tail;
        //尾节点指向头节点
        tail.prev=head;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E element) {
        Node<E> current=head;

        //循环到尾节点前
        while(current.next!=tail){
            current=current.next;
        }

        Node<E> newNode= new Node<>(element);
        newNode.next=tail;
        tail.prev=newNode;
        current.next=newNode;
        newNode.prev=current;

        size++;
    }

    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);

        newNode.next= head.next;
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
        Node<E> current=head.next;
        while(current!=tail){
            System.out.println(current.element);
            current=current.next;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.add(1);
        list.add(2);
        list.addFirst(3);
        list.add(4);
        list.display();
    }
}
