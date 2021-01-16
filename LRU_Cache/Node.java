package LRU_Cache;

public class Node {
    private String data;
    private int id;
    private Node nextNode;
    private Node prevNode;
    
    public Node(int id,String data){
        this.id = id;
        this.data = data;
    }
    
    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getPrevNode() {
        return this.prevNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

}
