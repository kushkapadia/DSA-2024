/*
class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
*/

class Pair implements Comparable<Pair>{
    int vtx, wsf;
    
    Pair(int vtx, int wsf){
        this.vtx = vtx;
        this.wsf = wsf;
    }
    
    public int compareTo(Pair o){
        return this.wsf - o.wsf;
    }
}

// User function Template for Java
class Solution {
    // Function to find the shortest distance of all the vertices
    // from the source vertex src.
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        ArrayList<Integer> ans = new ArrayList();
        PriorityQueue<Pair> pq = new PriorityQueue();
        
        for (int i = 0; i < adj.size(); i++) {
                ans.add(Integer.MAX_VALUE);
        }


        pq.add(new Pair(src, 0));
        
        while(pq.size()>0){
            Pair rem = pq.remove();
            
            if(ans.get(rem.vtx) != Integer.MAX_VALUE){
                continue;
            }
            
            ans.set(rem.vtx, rem.wsf);
            
            ArrayList<iPair> nbrs = adj.get(rem.vtx);
            for( iPair n : nbrs ){
                if(ans.get(n.first) != Integer.MAX_VALUE){
                    continue;
                }
                
               
                pq.add(new Pair(n.first, n.second + rem.wsf));
            }
            
        }
        return ans;
    }
}


// class Solution {
//     // Function to find the shortest distance of all the vertices from src.
//     ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
//         int n = adj.size();
//         ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));
//         PriorityQueue<Pair> pq = new PriorityQueue<>();

//         ans.set(src, 0);
//         pq.add(new Pair(src, 0));

//         while (!pq.isEmpty()) {
//             Pair rem = pq.poll();

//             // If the current path weight is greater, skip processing
//             if (rem.wsf > ans.get(rem.vtx)) {
//                 continue;
//             }

//             for (iPair n1 : adj.get(rem.vtx)) {
//                 int newDist = rem.wsf + n1.second;

//                 // Relaxation step: update if new distance is smaller
//                 if (newDist < ans.get(n1.first)) {
//                     ans.set(n1.first, newDist);
//                     pq.add(new Pair(n1.first, newDist));
//                 }
//             }
//         }
//         return ans;
//     }
// }