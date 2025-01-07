class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack();
        int ans = 0;
        for (int i = 0; i <= heights.length; i++) {
            int temp = 0;
            if (i != heights.length) {
                temp = heights[i];
            }

            while (st.size() > 0 && temp < heights[st.peek()]) {
                int tbs = st.pop(); // to be solved
                int nsr = i;
                int x1 = nsr - 1;// right side ka index
                int nsl = -1; // next smaller on left. By default it i s-1;

                if (st.size() > 0) {
                    nsl = st.peek(); // the stack will be in ascending order from down
                    // Obs: while Solving NSE on right NSE on left is just below.
                }

                int x2 = nsl + 1;
                int area = heights[tbs] * (x1 - x2 + 1);
            ans = Math.max(ans, area);

            }
            st.push(i);
        }

        return ans;
    }
}