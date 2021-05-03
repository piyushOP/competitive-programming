package Graph;

import java.io.*;
import java.util.*;
 
// Strongly-Connected-Components.
 
public class kosaraju {

	public static void main(String[] args) throws NumberFormatException, IOException {
	    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            int vtces = Integer.parseInt(str[0]);
            int edges = Integer.parseInt(str[1]);
            
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int i=0;i<vtces;i++) graph.add(new ArrayList<>());
            
            for(int i=0;i<edges;i++){
                String[] s = br.readLine().split(" ");
                int u =  Integer.parseInt(s[0]) - 1;
                int v = Integer.parseInt(s[1]) - 1;
                
                graph.get(u).add(v);

            }
            
            System.out.println(kosaraju(graph, vtces));
            
	}
	    
   public static int kosaraju(ArrayList<ArrayList<Integer>> graph, int n){
      Stack<Integer> st = new Stack<>();
      
      boolean visited[] = new boolean[n];
      
      for(int i=0;i<n;i++){
         if(visited[i]==false){
               dfs(graph, visited, i, st);
         }
      }
      
      ArrayList<ArrayList<Integer>> newGraph = transpose(graph,n);
      
      visited = new boolean[n];
      int count=0;
      
      while(!st.isEmpty()){
         int curr = st.pop();
         
         if(visited[curr] == false){
            dfs(newGraph, visited, curr);
            count++;
         }
      }
      
      return count;
   }
	    
   public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int v, Stack<Integer> st){
      visited[v] = true;
      
      for(int nbr : graph.get(v)){
         if(visited[nbr] == false){
               dfs(graph, visited, nbr, st);
         }
      }
      
      st.push(v);
   }
   
   public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int v){
      visited[v] = true;
      
      for(int nbr : graph.get(v)){
         if(visited[nbr] == false){
               dfs(graph, visited, nbr);
         }
      }
      
   }
   
   public static ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> graph, int n){
      ArrayList<ArrayList<Integer>> newGraph = new ArrayList<>();
      
      for(int i=0;i<n;i++) newGraph.add(new ArrayList<>());
      
      for(int i=0;i<n;i++){
         for(int nbr : graph.get(i)){
               newGraph.get(nbr).add(i);
         }
      }
      
      return newGraph;
   }

}
