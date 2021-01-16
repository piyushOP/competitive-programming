package Trie;

public class Node {
    static final int Size = 26;
    
    private String data;
    private Node[] children;
    private boolean leaf;
    private int value;
    
    
    public Node(String data){
        this.data = data;
        children = new Node[Size];
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node[] getChildren() {
        return this.children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return this.leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }


    public void setChild(int i,Node node,int value){
        this.children[i] = node;
        node.setValue(value);
    }

    public void setChild(int i,Node node){
        this.children[i] = node;
    }

    public Node getChild(int i){
        return children[i];
    }
}
