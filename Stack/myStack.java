package Stack;
import Linked_List.myLinkedList;

public class myStack<E> {
   private myLinkedList<E> list = new myLinkedList<>();

    void push(E data){
        list.insert(data);
    }

    public E pop() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Cannot remove from empty Stack");
        }
        return list.removeLast();
    }

    public E peek() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Cannot Peek");
        }

        return list.getLast();
    }
}
