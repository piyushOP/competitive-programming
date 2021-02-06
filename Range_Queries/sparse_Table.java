package Range_Queries;

import java.io.*;


public class sparse_Table{
   static int sparse[][] = new int[100000][100000];
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int arr[] = {3,1,2,6,5,1,-1,89,67};

      sparseTable(arr, arr.length);
      int queries = Integer.parseInt(br.readLine());

      for(int i=0;i<queries;i++){
         String[] str = br.readLine().split(" ");
         int low = Integer.parseInt(str[0]);
         int high = Integer.parseInt(str[1]);
         int ans = rmq(low, high);

         System.out.println(ans);
      }
   }


   private static void sparseTable(int[] arr, int n) {
      for(int i=0;i<n;i++) sparse[i][0] = arr[i];

      for(int j=1; (1<<j)<=n ; j++){
         for(int i=0; (i+(1<<j)-1)<n ; i++){

            if(sparse[i][j-1] < sparse[i+(1<<(j-1))][j-1]){
               sparse[i][j] = sparse[i][j-1];
            }else{
               sparse[i][j] = sparse[i+(1<<(j-1))][j-1];
            }
         }
      }
   }

   private static int rmq(int low, int high) {

      int j = (int)Math.log(high-low+1);
      
      return Math.min(sparse[low][j], sparse[high-(1<<j)+1][j]);
   }
}
