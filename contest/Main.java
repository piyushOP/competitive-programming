package contest;

import java.io.*;
import java.util.*;


public class Main {
  
  public static void main(String[] args) throws Exception {
    try {
      FastReader in = new FastReader();
      PrintWriter out = new PrintWriter(System.out);
      
        
      

      


      out.close();
    } catch (Exception e) {
      System.out.println(e);
      return;
    }
  }

  

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }

    String[] strArray() {
      String[] str = nextLine().split(" ");
      return str;
    }

    int[] intArray(int n) {
      String[] str = strArray();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(str[i]);
      }
      return arr;
    }
    
    long[] longArray(int n) {
      String[] str = strArray();
      long[] arr = new long[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Long.parseLong(str[i]);
      }
      return arr;
    }

    int[][] two_d_Array(int n, int m){
      int arr[][] = new int[n][m];
      for(int i=0;i<n;i++){
        String[] str = strArray();
        for(int j=0;j<m;j++){
          arr[i][j] = Integer.parseInt(str[j]);
        }
        
      }
      return arr;
    }

    Integer[] IntArray(int n) {
      String[] str = strArray();
      Integer[] arr = new Integer[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(str[i]);
      }
      return arr;
    }
  }
 

  private static void swap (int arr[], int a, int b){
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }



}
