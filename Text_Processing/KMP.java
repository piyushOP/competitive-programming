package Text_Processing;
import java.io.*;

// Used to find the pattern in String.

public class KMP {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String pattern = br.readLine();
        String str = pattern+"#"+text;

        // <--------Longest proper suffix which is also prefix : code---------->
        
        int dp[] = new int[str.length()];
        int i=1;
        int len = 0;
        while(i < str.length()){
            if(str.charAt(i) == str.charAt(len)){
                len++;
                dp[i] = len;
                i++;
            }else{
                if(len > 0){
                    len = dp[len-1];
                }else{  
                    i++;
                }
            }
         }

        // <------------------------------------------------------------->

        int count = 0;
        for(int val : dp){
            if(val == pattern.length()){
                count+=1;
            }
        }
        System.out.println(count);
    }    
}
