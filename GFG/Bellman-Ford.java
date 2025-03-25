// User function Template for Java

/*   Function to implement Bellman Ford
 *   edges: 2D array which represents the graph
 *   src: source vertex
 *   V: number of vertices
 */
class Solution {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        // Write your code here
        int e = edges.length;
    int[] ans = new int[V];
    
    Arrays.fill(ans, 100000000);
    
    ans[src] = 0;
        for(int i = 0; i< V-1; i++){
            
            for(int j = 0; j<e ; j++){
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];
                
                if(ans[u] != 100000000 && ans[v]  > ans[u] + wt){
                    ans[v] = ans[u] + wt;
                }
            }
            
        }
        
        //if after v-1 rounds, the edges got uypdated then it has. a negative edged cycle, therefore return -1;
           for(int j = 0; j<e ; j++){
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];
                
                if(ans[u] != 100000000 && ans[v]  > ans[u] + wt){
                      int[] an = {-1};
                     return an;

                }
            }
        return ans;
    }
}
