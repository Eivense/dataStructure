package dataStructure.linkedList;


/**
 * 泛型 链表
 * @param <E>
 */
public class LinkedList<E> implements List<E>{

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

    //链表头指针
    private Node<E> head;

    //链表长度
    private int size=0;

    public LinkedList() {
       this.head= new Node<>();
    }

    //获取链表长度
    @Override
    public int size(){
        return this.size;
    }


    //往链表尾部插入数据
    public LinkedList<E> add(E element){
        Node<E> current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next= new Node<>(element);
        size++;
        return this;

        //return add(element,size);
    }

    //往指定位置插入数据
    public LinkedList<E> add(E element,int index){
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
        return this;
    }

    //删除节点
    public void delete(int index){

    }

    //链表反转
    public void reverse(){

    }


    public void show(){
        Node<E> current=head.next;
        while(current!=null){
            System.out.println(current.element);
            current=current.next;
        }
    }


    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>();
        list.add(1).add(2);
        list.add(5,3);
        list.show();
    }

}
