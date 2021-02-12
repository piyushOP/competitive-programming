package Range_Queries;

import java.io.*;

public class fenwick_Tree_2D{

   static int[][] arr;
   static int[][] farr;
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] ar = br.readLine().split(" ");
      int n = Integer.parseInt(ar[0]);
      int m = Integer.parseInt(ar[1]);
      arr = new int[n+1][m+1];
      farr = new int[n+1][m+1];
      
      for(int i=1;i<=n;i++){
          String[] ele = br.readLine().split(" ");
          for(int j=1;j<=m;j++){
              arr[i][j] = Integer.parseInt(ele[j-1]);
          }
      }
      
      preprocess();
      
      int Q = Integer.parseInt(br.readLine());
      
      while(Q-->0){
          String[] str = br.readLine().split(" ");
          
          if(str[0].equals("q")){
              int x1 = Integer.parseInt(str[1]);
              int y1 = Integer.parseInt(str[2]);
              int x2 = Integer.parseInt(str[3]);
              int y2 = Integer.parseInt(str[4]);
              
              int val = query(x1,y1,x2,y2);
              System.out.println(val);
              
          }else{
              int x1 = Integer.parseInt(str[1]);
              int y1 = Integer.parseInt(str[2]);
              int val = Integer.parseInt(str[3]);
              update(x1,y1,val);
          }
      }
  }
  
   public static void preprocess(){
      for(int i=1;i<farr.length;i++){
          for(int j=1;j<farr[0].length;j++){
              update(i,j,arr[i][j]);
          }
      }
   }
  
   public static void update(int x, int y, int val){
      int tempX = x;
      
      while(tempX < arr.length){
          int tempY = y;
          while(tempY < arr[0].length){
              farr[tempX][tempY] += val;
              tempY += (tempY & -tempY);
          }
          tempX += (tempX & -tempX);
      }
   }
  
   public static int query(int x1, int y1, int x2, int y2){
      int inc1 = prefixSum(x2,y2);
      int exc1 = prefixSum(x1-1, y2);
      int exc2 = prefixSum(x2,y1-1);
      int inc2 = prefixSum(x1-1, y1-1);
      
      return inc1 + inc2 - exc1 - exc2;
   }
  
   public static int prefixSum(int x, int y){
      int sum=0;
      
      int tempX = x;
      
      while(tempX > 0){
          int tempY = y;
          while(tempY > 0){
              sum += farr[tempX][tempY];
              tempY -= (tempY & -tempY);
          }
          tempX -= (tempX & -tempX);
      }
      
      return sum;
   }
}
