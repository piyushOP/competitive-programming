package Red_Black_Tree;


public class RedblackTree{
    private Node root;

    public void traverse(){
        if(root!=null){
            inOrderTraversal(root);
        }
    }

    private void inOrderTraversal(Node node){
        if(node.getLeftChild()!=null){
            inOrderTraversal(node.getLeftChild());
        }
        System.out.print(node+" - ");
        if(node.getRightChild()!=null){
            inOrderTraversal(node.getRightChild());
        }        
    }

    public void insert(int data){
        Node node = new Node(data);
        root = insertIntoTree(root,node);
        fixVoilation(node);
    }

    private Node insertIntoTree(Node root, Node node){
        if(root==null){
            return node;
        }
        
        if(node.getData() < root.getData()){
            root.setLeftChild(insertIntoTree(root.getLeftChild(), node));
            root.getLeftChild().setParent(root);
        }else if(node.getData() > root.getData()){
            root.setRightChild(insertIntoTree(root.getRightChild(), node));
            root.getRightChild().setParent(root);
        }
        return root;
    }

    private void leftRotation(Node node){
        System.out.println("Rotating To The Right");

        Node tempLeftNode = node.getLeftChild();
        node.setLeftChild(tempLeftNode.getRightChild());

        if(node.getLeftChild()!=null){
            node.getLeftChild().setParent(node);
        }

        tempLeftNode.setParent(node.getParent());
        if(tempLeftNode.getParent()==null){
            root = tempLeftNode;
        }else if(node == node.getParent().getLeftChild()){
            node.getParent().setLeftChild(tempLeftNode);
        }else{
            node.getParent().setRightChild(tempLeftNode);
        }

        tempLeftNode.setRightChild(node);
        node.setParent(tempLeftNode);
    }

    private void rightRotation(Node node){
        System.out.println("Rotating To The Left");

        Node tempRightNode = node.getRightChild();
        node.setRightChild(tempRightNode.getLeftChild());

        if(node.getRightChild()!=null){
            node.getRightChild().setParent(node);
        }

        tempRightNode.setParent(node.getParent());
        if(tempRightNode.getParent()==null){
            root = tempRightNode;
        }else if(node == node.getParent().getRightChild()){
            node.getParent().setRightChild(tempRightNode);
        }else{
            node.getParent().setLeftChild(tempRightNode);
        }

        tempRightNode.setLeftChild(node);
        node.setParent(tempRightNode);
    }

    private void fixVoilation(Node node){
        Node parentNode = null;
        Node grandParentNode = null;

        while(node!=root && node.getColor()!=NodeColor.BLACK && node.getParent().getColor()==NodeColor.RED){

            parentNode = node.getParent();
            grandParentNode = node.getParent().getParent();

            if(parentNode == grandParentNode.getLeftChild()){
                Node uncle = grandParentNode.getRightChild();

                if(uncle!=null && uncle.getColor()==NodeColor.RED){
                    parentNode.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    grandParentNode.setColor(NodeColor.RED);
                    node = grandParentNode;
                }else{
                    if(node==parentNode.getRightChild()){
                        rightRotation(parentNode);
                        node = parentNode;
                        parentNode = node.getParent();
                    }

                    leftRotation(grandParentNode);
                    NodeColor tempColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());
                    grandParentNode.setColor(tempColor);
                    node = parentNode;
                    
                }
            }else{
                Node uncle = grandParentNode.getLeftChild();

                if(uncle!=null && uncle.getColor()==NodeColor.RED){
                    parentNode.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    grandParentNode.setColor(NodeColor.RED);
                    node = grandParentNode;
                }else{
                    if(node==parentNode.getLeftChild()){
                        leftRotation(parentNode);
                        node = parentNode;
                        parentNode = node.getParent();
                    }
                     
                    rightRotation(grandParentNode);
                    NodeColor tempColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());
                    grandParentNode.setColor(tempColor);
                    node = parentNode;
                    
                }
            }
        }
        if(root.getColor()==NodeColor.RED){
            root.setColor(NodeColor.BLACK);
        }
    }
}
