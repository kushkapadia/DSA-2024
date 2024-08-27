class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
double[] prob = new double[n]; //distance arr
prob[start_node] = 1; //the probablity of traversing the source node will be 1.

for(int i = 0; i<n-1;i++){
    boolean isChanged = false;
   int j = 0;
    //tweaked bellmanford
    for(int []edge : edges){
      
          int u = edge[0];
    int v = edge[1];
     double sp = succProb[j];
    j++;
    if(prob[v] < prob[u] * sp){
            prob[v] = prob[u] * sp;
            isChanged = true;
        }

        if(prob[u] < prob[v] * sp){
            prob[u] = prob[v] * sp;
            isChanged = true;
        }
         
    }
if(!isChanged){break;}
}


        return prob[end_node];
    }
}