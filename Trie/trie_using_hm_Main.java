package Trie;


public class trie_using_hm_Main {
   
   public static void main(String[] args){
      trieUsingHM trie = new trieUsingHM();
      trie.insert("Canada");
      trie.insert("Car");
      System.out.println(trie.contains("Car"));

      
   }

}
