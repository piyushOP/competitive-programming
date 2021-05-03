package Graph;

import java.io.*;
import java.util.*;

//TopoLogical Sort OR Scheduling.

public class Kahn_Algo{

	public static void main(String[] args) throws NumberFormatException, IOException {
	    
	    
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            int vtces = Integer.parseInt(str[0]);
            int edges = Integer.parseInt(str[1]);
            
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int i=0;i<vtces;i++) graph.add(new ArrayList<>());
            
            for(int i=0;i<edges;i++){
                String[] s = br.readLine().split(" ");
                int u =  Integer.parseInt(s[0]) ;
                int v = Integer.parseInt(s[1]) ;
                
                graph.get(v).add(u);

            }
            
            int inDegree[] = new int[vtces]; 
            
            for(int i=0;i<vtces;i++){
                for(int nbr : graph.get(i)){
                    inDegree[nbr]++;
                }
            }
            
            ArrayDeque<Integer> q = new ArrayDeque<>();
            for(int i=0;i<inDegree.length;i++){
                if(inDegree[i]==0) q.addLast(i);
            }
            
            int idx=0;
            int ans[] = new int[vtces];
            while(!q.isEmpty()){
                
                int rem = q.removeFirst();
                
                ans[idx++] = rem;
                
                for(int nbr : graph.get(rem)){
                    inDegree[nbr]--;
                    
                    if(inDegree[nbr] == 0) q.addLast(nbr);
                }
            }
            
            if(idx == vtces){
                for(int i=0;i<ans.length;i++)System.out.print(ans[i]+" ");
            }else{
                System.out.println(-1);
            }
            
	    }
    
    }
