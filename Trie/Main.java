package Trie;


public class Main {
    public static void main(String[] args){
        myTrie tree = new myTrie();
        // tree.insertAsMap("apple",1);
        // tree.insertAsMap("appa",2);
        // tree.insertAsMap("tree",3);
        // tree.insertAsMap("banana",4);
        // System.out.println(tree.search("appa"));
        // System.out.println(tree.search("orangae"));
        // List<String> list = tree.autoComplete("");
        
        // for(String s : list){
        //     System.out.println(s);
        // }

        // System.out.println(tree.searchAsMap("appa"));
        tree.insert("aba");
        System.out.println(tree.search("ab"));
    }
}
