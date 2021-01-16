package Red_Black_Tree;

public class Main {
    public static void main(String[] args){
        RedblackTree tree = new RedblackTree();
        tree.insert(10);
        tree.insert(6);
        tree.insert(3);
        tree.insert(100);
        tree.traverse();
    }
}
