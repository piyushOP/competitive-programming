package LRU_Cache;
import java.util.*;

public class Cache {
    public static final int CAPACITY = 4;
    private int size;
    private HashMap<Integer,Node> map;
    private DoublyLinkedList list;

    public Cache(){
        this.map = new HashMap<>();
        this.list = new DoublyLinkedList();
    }

    public void put(int id, String data){

        if(map.containsKey(id)){
            Node node = map.get(id);
            node.setData(data);

            update(node);
            return;
        }

        Node node = new Node(id,data);
        if(size <= CAPACITY){
            this.size++;
            add(node);
        }else{
            removeTail();
            add(node);
        }
    }

    private void add(Node node) {
        node.setNextNode(this.list.getHeadNode());
        node.setPrevNode(null);

        if(list.getHeadNode()!=null){
            list.getHeadNode().setPrevNode(node);
        }
        list.setHeadNode(node);
        if(list.getTailNode()==null){
            list.setTailNode(node);
        }

        this.map.put(node.getId(),node);
    }

    private void removeTail() {
        Node node = this.map.get(this.list.getTailNode().getId());

        this.list.setTailNode(list.getTailNode().getPrevNode());

        if(this.list.getTailNode()!=null){
            this.list.getTailNode().setNextNode(null);
        }
        
        node = null;
    }

    public String get(int id){
        if(this.map.containsKey(id)==false){
            return null;
        }

        Node node = this.map.get(id);
        update(node);
        return node.getId()+"-"+node.getData();
    }


    private void update(Node node) {
        Node prevNode = node.getPrevNode();
        Node nextNode = node.getNextNode();

        if(prevNode!=null){
            prevNode.setNextNode(nextNode);
        }else{
            this.list.setHeadNode(nextNode);
        }

        if(nextNode!=null){
            nextNode.setPrevNode(prevNode);
        }else{
            this.list.setTailNode(prevNode);
        }

        add(node);
    }

    public void show(){
        Node node = this.list.getHeadNode();
        while(node!=null){
            System.out.print(node.getId()+"-"+node.getData()+"<-->");
            node = node.getNextNode();
        }
    }
}
