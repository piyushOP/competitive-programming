package Range_Queries;

import java.io.*;
// Used to find sum of a range for multiple queries not useful for single query.
// Make prefix sum arr int O(n) but give ans to each query in O(1);


public class prefix_sum {
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int arr[] = {3,5,-1,4,10,1000,3,2,-1,-10,23,667};


      int query = Integer.parseInt(br.readLine());
      int prefixSum[] = new int[arr.length];
      prefixSum[0] = arr[0];
      for(int i=1;i<arr.length;i++){
         prefixSum[i] = prefixSum[i-1] + arr[i];
      }

      for(int x=0;x<query;x++){
         int i=Integer.parseInt(br.readLine());
         int j=Integer.parseInt(br.readLine());

         System.out.println(prefixSum[j] - prefixSum[i-1]);
      }
   }  
}
