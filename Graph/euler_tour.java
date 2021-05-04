package Graph;
import java.util.*;
import contest.Main.FastReader;

// Used to find in-time and out-time of every node;
// Application - to Find ancestor, to check whether a node is in the subtree or not.


public class euler_tour{
   static int euler[]; //Euler path
   static int inTime[]; //For ancestor ques
   static int outTime[]; //For ancestor ques
   static int idx=0; //index for euler path
   static int time=1; //for ancestor ques to update timing.
   
   public static void main(String[] args){
      try{
         FastReader in = new FastReader();
         int vtces = in.nextInt();
         int edges = in.nextInt();

         ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
         for(int i=0;i<=vtces;i++){
            graph.add(new ArrayList<>());
         }

         for(int i=0;i<edges;i++){
            int u = in.nextInt();
            int v = in.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
         }
         boolean visited[] = new boolean[vtces+1];
         euler = new int[2*vtces-1];
         inTime = new int[vtces+1];
         outTime = new int[vtces+1];
         eulerTour(graph, visited, 1);

         // Print euler Path
         for(int val : euler){
            System.out.print(val +" ");
         }

         //Print in and out time
         for(int i=1;i<inTime.length;i++){
            System.out.println("entry-"+inTime[i]+"  "+"exit-"+outTime[i]);
         }
         
         //To check Ancestor
         int q = in.nextInt();
         while(q-- > 0){
            int par = in.nextInt();
            int child = in.nextInt();

            boolean ans = inTime[par]<=inTime[child] && outTime[par]>=outTime[child];
            System.out.println(ans);
         }


      } catch (Exception e) {
         System.out.println(e);
         return;
      }
   }


   private static void eulerTour(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int src) {
      visited[src] = true;
      euler[idx++] = src;
      inTime[src] = time++;

      for(int nbr : graph.get(src)){
         if(visited[nbr] == false){
            eulerTour(graph, visited, nbr);
            euler[idx++] = src;
         }
      }
      outTime[src] = time++;
   }

}
