package Trie;
import java.util.*;

public class myTrie {
    private Node root;

    myTrie(){
        this.root = new Node("");
    }

    public void insertAsMap(String key,int value){
        Node tempNode = root;

        for(int i=0;i<key.length();i++){
            char ch = key.charAt(i);
            int index = ch - 'a';

            if(tempNode.getChild(index)==null){
                Node node = new Node(String.valueOf(ch));
                tempNode.setChild(index, node,value);
                tempNode = node;
            }else{
                tempNode = tempNode.getChild(index);
            }
        }
        tempNode.setLeaf(true);
    }

    public void insert(String key){
        Node tempNode = root;

        for(int i=0;i<key.length();i++){
            char ch = key.charAt(i);
            int idx = ch-'a';

            if(tempNode.getChild(idx)==null){
                String data = String.valueOf(ch);
                Node node = new Node(data);
                tempNode.setChild(idx, node);
                tempNode = node;
            }else{
                tempNode = tempNode.getChild(idx);
            }

        }
        tempNode.setLeaf(true);
    }

    public boolean search(String key){
        Node tempNode = root;

        for(int i=0;i<key.length();i++){
            char ch = key.charAt(i);
            int index = ch - 'a';

            if(tempNode.getChild(index)==null){
                return false;
            }else{
                tempNode = tempNode.getChild(index);
            }
        }
        return true;
    }

    public Integer searchAsMap(String key){
        Node tempNode = root;

        for(int i=0;i<key.length();i++){
            char ch = key.charAt(i);
            int index = ch - 'a';

            if(tempNode.getChild(index)!=null){
                tempNode = tempNode.getChild(index);
            }else{
                return null;
            }
        }
        return tempNode.getValue();
    }

    public List<String> autoComplete(String prefix){
        Node tempNode = root;
        List<String> ans = new ArrayList<>();

        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            tempNode = tempNode.getChild(index);
        }
        collect(ans,tempNode,prefix);
        return ans;        
    }

    private void collect(List<String> ans, Node node,String prefix){
        if(node==null) return;

        if(node.isLeaf()){
            ans.add(prefix);
        }

        for(Node childNode : node.getChildren()){
            if(childNode==null) continue;

            String childChar = childNode.getData();
            collect(ans,childNode,prefix+childChar);
        }
    }
}
