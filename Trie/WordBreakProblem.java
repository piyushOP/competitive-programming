package Trie;
import java.io.*;


public class WordBreakProblem {
    static myTrie trie = new myTrie();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dict = {"mobile","samsung","sam","sung","ma","mango","icecream","and","go","i","like","ice","cream","leet","code","apple","pen"};
        
        for(int i=0;i<dict.length;i++){
            trie.insert(dict[i]);
        }

        String str = br.readLine();
        System.out.println(wordBreak(str) ? "YES" : "NO");
    }

    public static boolean wordBreak(String key) {
        int size = key.length();

        if (size == 0){
            return true;
        }

        for (int i = 1; i <= size; i++) {

            if (trie.search(key.substring(0, i)) && wordBreak(key.substring(i, size))){
                return true;
            }
        }
        return false;
    }
}
