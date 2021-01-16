package Text_Processing;

import java.io.*;

// Used to calculate longest palindromic substring in 0(n) 

public class Manacher {
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s = br.readLine();
      String str = newStr(s);
      int lps[] = new int[str.length()];
      int r=0;
      int c=0;
      for(int i=1;i<lps.length-1;i++){
         int mirr = c-(i-c);
         if(r > i){
            lps[i] = Math.min(lps[mirr], r-i);
         }

         while(str.charAt(i+lps[i]+1) == str.charAt(i-lps[i]-1)){
            lps[i]++;
         }

         if(i > r){
            c=i;
            r=lps[i] + i;
         }
      }

      int max=0;
      int maxidx=0;
      for(int i=1;i<lps.length-1;i++){
         if(lps[i] > max){
            max = lps[i];
            maxidx = i;
         }
      }
      System.out.println(max);

      int original_idx = maxidx - max + 1;
      original_idx = (original_idx - 2)/2;

      System.out.println(s.substring(original_idx, original_idx+max));
   }

   private static String newStr(String str){
      StringBuilder sb = new StringBuilder();
      sb.append(("@"));
      for(int i=0;i<str.length();i++){
         sb.append("#");
         sb.append(str.charAt(i));
      }

      sb.append("#");
      sb.append("&");

      return sb.toString();
   }

}
