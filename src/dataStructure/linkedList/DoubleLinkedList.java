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

        // 当链表为空时 需要处理尾节点
        if(isEmpty()){
            head.next=newNode;
            newNode.prev=head;
            newNode.next=tail;
            tail.prev = newNode;
        }
        // 不为空时 不需要处理尾节点
        else{
            head.next.prev = newNode;
            newNode.next= head.next;
            newNode.prev=head;
            head.next=newNode;
        }

        size++;
    }

    @Override
    public void add(int index, E element) {
        if(index<1||index>size){
            throw new IndexOutOfBoundsException("超出范围");
        }

        Node<E> current=head;
        // 循环到指定位置
        for (int i = 1; i < index; i++) {
            current=current.next;
        }

        Node<E> newNode = new Node<>(element);
        current.next.prev=newNode;
        newNode.next=current.next;
        newNode.prev=current;
        current.next = newNode;

        size++;
    }

    @Override
    public void remove(int index) {
        if(index<1||index>size){
            throw new IndexOutOfBoundsException("超出范围");
        }

        Node<E> current=head;
        // 循环到指定位置
        for (int i = 1; i < index; i++) {
            current=current.next;
        }

        current.prev.next=current.next;
        current.next.prev = current.prev;

        size--;

    }


    /**
     *  反转 非递归
     */
    @Override
    public void reverse() {

        //保存当前节点
        Node<E> current=head.next;
        //保存上一节点
        Node<E> previous=tail;
        Node<E> next;
        while(current!=tail){
           next=current.next;
           current.next=previous;
           previous.prev=current;
           previous=current;
           current = next;
        }
        previous.prev=head;
        head.next = previous;
    }


    /**
     * 反转 递归实现
     *
     */
    public Node<E> reverse(Node<E> head) {
        if(head==null||head.next==null){
            return head;
        }
        Node<E> prev = reverse(head.next);

        if(head!=this.head){
            head.next.next = head;
            head.next = tail;
            head.prev=prev;
        }else{
            this.head=prev;
        }
        return prev;
    }


    @Override
    public void display() {
        Node<E> current=head.next;
        while(current!=tail){
            System.out.println(current.element);
            current=current.next;
        }
    }


    /**
     * 倒序输出
     */
    public void reverseDisplay(){
        Node<E> current=tail.prev;
        while(current!=head){
            System.out.println(current.element);
            current = current.prev;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(3);

        list.display();
        System.out.println("-------------");
        list.reverse(list.head);
        list.display();
        list.reverseDisplay();

    }
}
