package Graph;
import java.util.*;
import java.io.*;

import contest.Main.FastReader;


public class kruskal{

   static class Edge implements Comparable<Edge>{
      int src;
      int nbr;
      int wgt;
      public Edge(int src, int nbr ,int wgt){
         this.src=src;
         this.nbr=nbr;
         this.wgt = wgt;
      }
      
      public int compareTo(Edge o) {
         return this.wgt - o.wgt;
      }
   }

   public static void main(String[] args){
      try{
         FastReader in = new FastReader();
         PrintWriter out = new PrintWriter(System.out);
         int n = in.nextInt();
         int e = in.nextInt();
         Edge[] graph = new Edge[e];

         for(int i=0;i<e;i++){
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            graph[i] = new Edge(u,v,w);
         }

         Arrays.sort(graph);

         Edge[] output = kruskal(graph,n,e);
         for(Edge val : output){
         out.println(val.src+" "+val.nbr+" "+val.wgt);
         }
      
         out.close();
      } catch (Exception e) {
         System.out.println(e);
         return;
      }
   }
   
   private static Edge[] kruskal(Edge[] graph, int n, int edges) {
      Edge[] ans = new Edge[n-1];
      // check parent whether two vertices are in same component or not
      int [] parent = new int[n];
      // initailsize every vertex as parent of themselves 
      for(int i=0;i<n;i++){
         parent[i] = i;
      }

      int i=0;
      int count=0;

      while(count < (n-1)){

         Edge curr = graph[i];

         int srcParent = getParent(curr.src, parent);
         int nbrParent = getParent(curr.nbr,parent);

         if(srcParent != nbrParent){
            ans[count] = curr;
            count++;
            parent[srcParent] = nbrParent;
         }
         i++;
      }

      return ans;
   }

   private static int getParent(int src, int parent[]) {
      if(parent[src] == src){
         return src;
      }

      return getParent(parent[src], parent);
   }

}
