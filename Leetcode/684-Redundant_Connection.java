class Solution {

    int[] par;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] ans = new int[2];
        par = new int[n+1];
        rank = new int[n+1];

        for(int i = 0; i<n; i++){
            par[i] = i;
            rank[i] = 1;
        }
        //obs1: the extra vertex added ill always form a cycle 
        //obs2: if any edge was already merged, it means, it forms a cycle.
        //when the merge fails, return that edge
        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            boolean merge = union(u, v);

            if (merge == false) {
                return edges[i];
                // break;
            }
        }
        return ans;
    }

    public boolean union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px == py){
            return false;
        }
        if(rank[px]> rank[py]){
            par[py] = px;
        } else if( rank[px] < rank[py]){
            par[px] = py;
        } else{
            par[px] = py;
            rank[py]++;
        }
        return true;
    }

    public int find(int x){
        if(x == par[x]){
            return x;
        }

        int temp = find(par[x]);
        par[x] = temp;
        return temp;
    }
}