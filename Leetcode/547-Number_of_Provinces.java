//disjoint set union (DSU) 
//TC: O(V + E) //after applying optimization. (Amortized)

class Solution {

    int[] parent; // keep the length of parent
    int[] rank; // keeps the record for length of chain from parent element

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;

            // by default length is one (self element)
            rank[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (isConnected[i][j] == 1)
                    union(i, j);
            }

        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                ans++;
            }
        }
        return ans;
    }

    public void union(int x, int y) {

        int px = find(x);
        int py = find(y);

        if (px == py) {
            return;
        }
        // we connect the smaller chain the longer chain. hence making px as the parent
        // of py
        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[py] > rank[px]) {
            parent[px] = py;
        } else {
            parent[px] = py;
            // when we connect to eqal length chain, the length of chain increases by one.
            rank[py]++;
        }
    }

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
}

// 0 2 3

// 0- 1 1 0
// 1- 1 1 0
// 3- 0 0 1

// i = 1 j = 1 = 1