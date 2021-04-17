package Trie;

import java.util.*;

public class trieUsingHM{
   
   private static class Node{
      private char val;
      private HashMap<Character,Node> children = new HashMap<>();
      private boolean isEndOfWord;

      public Node(char ch){
         this.val = ch;
      }

      public boolean hasChild(char ch){
         return children.containsKey(ch);
      }

      public void addChild(char ch){
         children.put(ch, new Node(ch));
      }

      public Node getChild(char ch){
         return children.get(ch);
      }
   }

   private Node root = new Node('#');

   public void insert(String str){
      Node curr = root;
      for(char ch : str.toCharArray()){
         if(!curr.hasChild(ch)){
            curr.addChild(ch);
         }
         curr = curr.getChild(ch);
      }
      curr.isEndOfWord = true;
   }

   public boolean contains(String str){
      Node curr = root;
      for(char ch : str.toCharArray()){
         if(curr.hasChild(ch) == false) return false;
         curr = curr.getChild(ch);
      }

      return curr.isEndOfWord;
   }

   public void remove(String word){
      remove(root, word,0);
   }

   private void remove(Node root, String word, int idx){
      if(idx == word.length()-1){
         root.isEndOfWord = true;
         return;
      }
      
      char ch = word.charAt(idx);
      Node child = root.getChild(ch);

      if(child==null) return;

      remove(child, word, idx+1);


   }
}
