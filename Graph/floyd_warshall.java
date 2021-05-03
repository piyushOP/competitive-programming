package Graph;




public class floyd_warshall{
   static int INF = 100000;
   public static void main(String[] args){
      try{
         int[][] graph = {{0,INF,-2,INF},
                          {4,0,3,INF},
                          {INF,INF,0,2},
                          {INF,-1,INF,0}};
         
                          
         int ans[][] = floydWarshall(graph);

         for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans.length;j++){
               System.out.print(ans[i][j]+"  ");
            }
            System.out.println();
         }

      } catch (Exception e) {
         System.out.println(e);
         return;
      }
   }

   public static int[][] floydWarshall(int[][] graph){
      int[][] dist = graph;
      int V = graph.length;


      for(int k=0;k<V;k++){ // Phases to traverse & Check every vertex as middle link from one vertex to another.

         for(int i=0;i<V;i++){  //Traverse the graph - row Wise.

            for(int j=0;j<V;j++){ //Traverse the graph - Col Wise.

               dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]); // Check whether there is any shortest path using K.

            }
         }
      }

      return dist;
   }

}
