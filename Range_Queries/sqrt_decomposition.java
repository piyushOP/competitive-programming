package Range_Queries;
import java.util.*;

// Used in range queries to give ans to each query in sqrt(n) time;
// Total time would to - Preprocessing the sqrt array would be O(n) & for each
// query q would be O(q*sqrt(n)) which is equal to O(q*log(n));


// Q. Find the minimum for every Query.


public class sqrt_decomposition {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int arr[] = { 1, 2, 4, 5, 8, 2, 3, 0, 9, 10 };
      int len = (int)Math.ceil(Math.sqrt(arr.length)); //Math.ceil is because what if any array's length is not a perfect square to any number.
      int sqrt[] = sqrt(arr,len);

      int queries = 1;
      while(queries-->0){ // Taking every query.
         int l = sc.nextInt();
         int r = sc.nextInt();
         int min = Integer.MAX_VALUE;
         while(l<=r){
            if(l%len==0 && l+len-1<=r){ // Here we are checking whether we can use sqrt table or not and take data in O(1) so, if (l%len==0) that means l is on the starting of the particular range and should be less than or equal to r.
               min = Math.min(min, sqrt[l/len]);
               l+=len; // so we take data from sqrt the  we can jump over to the next range.
            }else{
               min = Math.min(min, arr[l]); // Otherwise we have to Traverse the arr;
               l++;
            }
         }
         System.out.println(min);
      }

      // So we Traverse in three different ranges.
      // 1. where l is not the starting of the range. Max run - O(sqrt(n))
      // 2. where the running range is between l and r. so we use sqrt array. Max run - O(sqrt(n))
      // 3. where r in is not the ending of the range. Max run - O(sqrt(n))

      // Total is 3*sqrt(n) which is equal to O(sqrt(n)) for every query.

// -------------------------------------------------------------------------------//
      
      int updateVal = -10; //update query for min value
      int updateIdx = 7;

      arr[updateIdx] = updateVal;
      int idx = updateIdx/len;
      sqrt[idx] = Math.max(sqrt[idx], updateVal);
      
   }

   public static int[] sqrt(int arr[],int len){
      int sqrt[] = new int[len]; // length is sqrt of n;
      Arrays.fill(sqrt, Integer.MAX_VALUE); // particular case for min_value question

      for(int i=0;i<arr.length;i++){
         int idx = i/len; // it gives the index of sqrt array to compare the value
                           // because when we divide original index of arr with sqrt(n) which is len here, we can find out which range should be considered in sqrt array. 
         if(arr[i] < sqrt[idx]){
            sqrt[idx] = arr[i];
         }
      }

      return sqrt;
   }
}
