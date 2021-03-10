package Range_Queries;

import java.io.*;

public class Segment_Tree_array{
   static int st[];
   static int arr[];
   public static void main (String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(System.out);
      String str1[] = br.readLine().split(" ");
      int n = Integer.parseInt(str1[0]);
      int q = Integer.parseInt(str1[1]);

      st = new int[2*n-1];

      String ele[] = br.readLine().split(" ");
      arr = new int[n];
      for(int i=0;i<n;i++){
         arr[i] = Integer.parseInt(ele[i]);
      }

      BuildST(0,n-1,0,arr);
   
      while(q-->0){
         String str[] = br.readLine().split(" ");
         int l = Integer.parseInt(str[0]);
         int r = Integer.parseInt(str[1]);
        out.println(query(0, n-1, l-1, r-1, 0));
         
      }

      out.close();
            
   }


   private static void BuildST(int low, int high,int pos,  int[] arr) {
      if(low == high){
         st[pos] = arr[low];
         return;
      }

      int mid = low+(high-low)/2;
      BuildST(low, mid, 2*pos+1, arr);
      BuildST(mid+1, high, 2*pos+2, arr);
      st[pos] = (st[2*pos+1] ^ st[2*pos+2]);
   }

   public static int query(int low, int high, int ql, int qh, int pos){
      if(ql<=low && qh>=high){
         return st[pos];
      }

      if(ql>high || qh<low){
         return 0;
      }

      int mid = low+(high-low)/2;
      int max1 = query(low, mid, ql, qh, 2*pos+1);
      int max2 = query(mid+1, high, ql, qh, 2*pos+2);

      return (max1^max2);
   }

   public static void update(int idx, int val,int low, int high, int pos){
      if(idx>high || idx<low) return;
      if(low == high){
         arr[idx] = val;
         st[pos] = val;
         return;
      }
      int mid = low+(high-low)/2;
      
      update(idx, val, low, mid, 2*pos+1);
      update(idx, val, mid+1,high,2*pos+2);

      st[pos] = Math.max(st[2*pos+1], st[2*pos+2]);
   }
}
