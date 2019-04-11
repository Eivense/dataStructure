package dataStructure.linkedList;


/**
 * 单向链表
 * @param <E>
 */
public class LinkedList<E> implements List<E>{

    //链表头节点
    private transient  Node<E> head;

    //链表长度
    private int size=0;

    //内部节点类
    class Node<E>{

        //数据
        E element;
        //指向下一个节点
        Node<E> next;

        Node() {
        }
        Node(E element) {
            this.element= element;
        }
    }

    public LinkedList() {
       this.head= new Node<>();
    }

    //获取链表长度
    @Override
    public int size(){
        return this.size;
    }


    //往链表尾部插入数据
    public void add(E element){
        Node<E> current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next= new Node<>(element);
        size++;
        //add(element,size);
    }

    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);

        newNode.next= head.next;
        head.next=newNode;
        size++;

    }


    //往指定位置插入数据
    @Override
    public void add(int index, E element) {
        if(index<1||index>size+1){
            throw new IndexOutOfBoundsException("超出范围");
        }

        Node<E> current=head;
        //循环到插入位置
        for (int i = 1; i < index; i++) {
            current=current.next;
        }
        Node<E> newNode=new Node<>(element);
        newNode.next=current.next;
        current.next=newNode;
        size++;
    }

    @Override
    public void remove(int index) {
        if(index<1||index>size+1){
            throw new IndexOutOfBoundsException("超出范围");
        }

        Node<E> current=head;
        //循环到删除位置
        for (int i = 1; i < index; i++) {
            current=current.next;
        }

        Node<E> temp=current.next;
        current.next=temp.next;
        size--;
    }


    /**
     * 反转 非递归
     *
     * 遍历链表，把每个节点插入到头节点之后
     */
    @Override
    public void reverse() {
        // 保存当前节点
        Node<E> current=head.next;
        // 保存上一节点
        Node<E> previous=null;
        // 保存下一节点
        Node<E> next;

        //current为空说明已经到了链表的尾
        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        head.next=previous;

    }


    @Override
    public void display() {
        Node<E> current=head.next;
        while(current!=null){
            System.out.println(current.element);
            current=current.next;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 反转 递归实现
     *
     * 通过递归，先递归到最后一个节点然后开始往前返回倒序遍历每一个节点
     * @param current 当前节点
     * @return 返回的是当前反转之后的头节点
     */
    public Node<E> reverse(Node<E> current){
        // 从最后一个有数据的节点开始返回
        if(current==null||current.next ==null)
            return current;

        //递归到最后一个非空节点开始返回
        Node<E> prev = reverse(current.next);

        //头节点不包含数据因此需要进行判断
        if(current!=this.head) {
            current.next.next = current;
            current.next = null;
        }else{
            //头节点指向当前反转之后的第一个数据节点
            current.next=prev;
            return current;
        }
        return prev;
    }



    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);

        list.display();
        System.out.println("--------------");
        list.reverse(list.head);
        list.display();
    }

}
