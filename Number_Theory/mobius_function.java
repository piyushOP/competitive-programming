package Number_Theory;

import java.io.*;
import java.util.*;
// Mobius Function has only 3 values {-1,1,0}
// Mobius(n) = 1, if n is a sqaure-free positive integer & even number of prime factors -> (10) -> 2*5 -> even factors & non squared.
// Mobius(n) = -1, if n is a sqaure-free positive integer & odd number of prime factors -> (30) -> 2*3*5 -> odd factors & non squared.
// Mobius(n) = 0, if n has sqared prime factors -> (4) -> 2*2 -> squared factors.

// Mobius Function can be implemented using sieve.


// Q. Print mobius sequence till n ?

public class mobius_function {
   static int n = 10006;
   static int prime_count[] = new int[n];
   static int mob[] = new int[n];
   static int arr[] = new int[n];
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      mobius_cal();
      int x = Integer.parseInt(br.readLine());
      for(int i=1;i<=x;i++){
         System.out.print(mob[i]+" ");
      }
   }

   private static void mobius_cal() {
      Arrays.fill(arr,1);

      for(int i=2;i<n;i++){
         if(prime_count[i] > 0) continue;
         for(int j=i;j<n;j+=i){
            prime_count[j]++;
            arr[j]*=i;
         }
      }

      for(int i=1;i<n;i++){
         if(arr[i]==i){
            if(prime_count[i]%2==1){
               mob[i] = -1;
            }else{
               mob[i] = 1;
            }
         }else{
            mob[i] = 0;
         }
      }
   }
}
