package Graph;

import java.io.*;
import java.util.*;
 

// Shortest Path for every vertex from 1.

public class bellman_ford {
	public static void main(String[] args) throws NumberFormatException, IOException {
        
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            int vtces = Integer.parseInt(str[0]);
            int edges = Integer.parseInt(str[1]);
            
            int arr[][] = new int[edges][3];
            
            for(int i=0;i<edges;i++){
                str = br.readLine().split(" ");
                arr[i][0] = Integer.parseInt(str[0]) - 1;
                arr[i][1] = Integer.parseInt(str[1]) - 1;
                arr[i][2] = Integer.parseInt(str[2]);
            }
            
            int[] path = new int[vtces];
            Arrays.fill(path, Integer.MAX_VALUE);
            path[0] = 0;
            
            for(int i=0;i<vtces-1;i++){ //Traverse V-1 times.
                for(int j=0;j<edges;j++){
                    int u = arr[j][0];
                    int v = arr[j][1];
                    int w = arr[j][2];
                    
                    if(path[u] == Integer.MAX_VALUE) continue;
                    
                    if(path[u] + w < path[v]){
                        path[v] = path[u] + w;
                    }
                }
            }
            
            for(int i=1 ;i< path.length;i++){
                if(path[i] != Integer.MAX_VALUE){
                    System.out.print(path[i]+" ");
                }else{
                    System.out.print("1000000000 ");
                }
            }
            
            System.out.println();
		}
}
