package dataStructure.linkedList;


/**
 * 泛型 链表
 * @param <E>
 */
public class LinkedList<E> implements List<E>{

    //链表头指针
    private Node<E> head;

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
    public void addHead(E element) {

    }


    //往指定位置插入数据
    @Override
    public void add(int index, E element) {
        if(index>size){
            throw new IndexOutOfBoundsException("超出范围");
        }
        Node<E> current=head;
        while(index>0){
            current=current.next;
            index--;
        }
        Node<E> newNode=new Node<>(element);
        newNode.next=current.next;
        current.next=newNode;
        size++;
    }

    @Override
    public void remove(int index, E element) {

    }

    @Override
    public void reverse() {
        //保存当前节点
        Node<E> current=head.next;
        //保存上一节点
        Node<E> previous=null;
        while(current!=null){
            Node<E> next=current.next;
            //next为空说明已经到了链表的尾
            if(next==null){
                head.next=current;
            }
            current.next=previous;
            previous=current;
            current=next;
        }
    }


    @Override
    public void display() {
        Node<E> current=head.next;
        while(current!=null){
            System.out.println(current.element);
            current=current.next;
        }
    }



    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.reverse();
        list.display();
    }

}
