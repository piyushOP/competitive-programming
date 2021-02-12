package Range_Queries;

import java.io.*;

// Fenwick Tree also Know as Binary Index Tree
// Based on bits.
// preprocess = O(nlogn) / O(n) using prefix sum, update = O(logn), query = O(logn)


// Q. Range Sum ?

public class fenwick_Tree{
   static int farr[];
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int arr[] = new int[n+1];
      String[] elements = br.readLine().split(" ");
      for(int i=1;i<arr.length;i++){
         arr[i] = Integer.parseInt(elements[i-1]);
      }

      preProcessNlogN(arr);
      preProcessInOn(arr);
      int Q = Integer.parseInt(br.readLine());
      for(int i=0;i<Q;i++){
         String[] st = br.readLine().split(" ");
         if(st[0].equals("q")){
            int val = query(Integer.parseInt(st[1]), Integer.parseInt(st[2]));
            System.out.println(val);
         }else{
            update(Integer.parseInt(st[1]), Integer.parseInt(st[2]));
         }
      }
   }

   private static void preProcessInOn(int[] arr) {
      farr = new int[arr.length];
      int prefix[] = new int[arr.length];
      for(int i=1;i<arr.length;i++){
         prefix[i] = arr[i] + prefix[i-1];
      }

      for(int i=1;i<farr.length;i++){
         int idx = i - (i & -i); // off least significant bit and go downwards to get val of some other idx;
         farr[i] = prefix[i] - prefix[idx];
      }
   }

   public static void preProcessNlogN(int[] arr) {
      farr = new int[arr.length];
      for(int i=1;i<farr.length;i++){
         update(i, arr[i]);
      }
   }

   public static void update(int idx, int val){
      while(idx < farr.length){
         farr[idx] += val;
         idx = idx + (idx & -idx); // going updwards to change the value
      }
   }

   public static int query(int l ,int r){
      return prefixSum(r) - prefixSum(l-1);
   }

   public static int prefixSum(int idx){
      int sum=0;  
      while(idx > 0){
         sum += farr[idx];
         idx = idx-(idx & -idx); //off least significant set bit and going downwards.
      } 

      return  sum;
   }
}
