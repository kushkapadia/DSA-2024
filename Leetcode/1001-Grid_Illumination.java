class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        HashMap<Integer, Integer> m1 = new HashMap(); // for counting lamps in the row
        HashMap<Integer, Integer> m2 = new HashMap(); // for counting lamps in the col
        HashMap<Integer, Integer> m3 = new HashMap(); // for counting lamps on the diagonal ( from top left to bottom
                                                      // right)
        // each diagonal has a number
        // top left to bottom right --> Formula: row - col;
        // top right to bottom left --> formula: row+col;
        HashMap<Integer, Integer> m4 = new HashMap(); // for coutning lamps on the diagonal top right to bottom left
        HashMap<Integer, Integer> m5 = new HashMap(); // flatten the 2d array into 1d array and store number of lamps at
                                                      // each position.
        // formula row * (length of grid) + column.
        // Note: There can be multiple lamps at the same position (as per the question)

        // store everything on all the hasmpas
        for (int i = 0; i < lamps.length; i++) {
            int x = lamps[i][0]; // 0 for row
            int y = lamps[i][1]; // 1 for col;

            m1.put(x, m1.getOrDefault(x, 0) + 1);
            m2.put(y, m2.getOrDefault(y, 0) + 1);
            m3.put(x - y, m3.getOrDefault(x - y, 0) + 1);
            m4.put(x + y, m4.getOrDefault(x + y, 0) + 1);
            m5.put(x * n + y, m5.getOrDefault(x * n + y, 0) + 1);
        }

        // distance 2d array for 9 points (top, left, right, down and all diagonal and
        // itself)

        int[][] dist = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 },
                { 0, 0 } };

        int ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];

            if (m1.getOrDefault(x, 0) > 0 || m2.getOrDefault(y, 0) > 0 || m3.getOrDefault(x - y, 0) > 0
                    || m4.getOrDefault(x + y, 0) > 0) {
                // this cell is illuminated by some or the other lamp;
                ans[i] = 1; // as it is illuminated, mark it as 1
            }

            // now we have to remove the lamp from all 9 positions around the illuminated
            // block that are mentioned in the question

            for (int d = 0; d < dist.length; d++) {
                int x1 = x + dist[d][0];
                int y1 = y + dist[d][1];

                // check bounds

                if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < n && m5.containsKey(x1 * n + y1) == true) {

                    int times = m5.get(x1 * n + y1); //lamp can be present multiple times at the same position (as per the question)

                    m1.put(x1, m1.getOrDefault(x1, 0) - times); //subtract those occurences wherever we stored it initially
                    m2.put(y1, m2.getOrDefault(y1, 0) - times);
                    m3.put(x1 - y1, m3.getOrDefault(x1 - y1, 0) - times);
                    m4.put(x1 + y1, m4.getOrDefault(x1 + y1, 0) - times);
                    m5.remove(x1 * n + y1); //completely remove from the lamp from the grid

                }

            }

        }
        return ans;
    }
}