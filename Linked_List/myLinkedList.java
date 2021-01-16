package Linked_List;

public class myLinkedList<E> {
    Node<E> head;

    public void insert(E data){
        Node<E> node = new Node<E>(data);

        if(isEmpty()){
            head = node;
            return;
        }

        Node<E> temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = node;
    }

    public E removeLast() throws Exception{
        Node<E> temp = head;
        
        if(temp==null){
            throw new Exception("Cannot Remove");
        }

        if(temp.next==null){
            Node<E> toRemove = head;
            head = null;
            return toRemove.data;
        }

        while(temp.next.next!=null){
            temp = temp.next;
        }
        Node<E> toRemove = temp.next;
        temp.next = null;
        return toRemove.data;
    }

    public E getLast() throws Exception{
        Node<E> temp = head;
        
        if(temp==null){
            throw new Exception("Cannot Remove");
        }

        while(temp.next!=null){
            temp = temp.next;
        }
        return temp.data;
    }

    public void print(){
        Node<E> temp = head;
        while(temp!=null){
            System.out.print(temp.data+"-");
            temp = temp.next;
        }
    }

    public boolean isEmpty(){
        return head==null;
    }
}
