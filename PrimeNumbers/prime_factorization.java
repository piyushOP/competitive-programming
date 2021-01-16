package PrimeNumbers;

import java.io.*;
import java.util.*;


public class prime_factorization {
   static int arr[] = new int[1000001];
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int maxN = 1000001;
      Arrays.fill(arr,-1);

      for(int i=2;i<=Math.sqrt(maxN);i++){
         if(arr[i] == -1){
            for(int j=i; j<=Math.sqrt(maxN) ;j+=i){
               if(arr[j]==-1){
                  arr[j] = i;
               }  
            }
         }
      }

      System.out.println(arr[10]);
   }
}
