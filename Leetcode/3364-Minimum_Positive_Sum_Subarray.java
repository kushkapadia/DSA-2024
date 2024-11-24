class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans = Integer.MAX_VALUE;
        int n = nums.size();
        for (int ws = l; ws <= r; ws++) {
            int sum = 0;
            for (int i = 0; i < ws; i++) {
                sum = sum + nums.get(i);
            }

            if (sum > 0) {
                ans = Math.min(ans, sum);
            }

            // aquire release

            int sp = 0;
            int ep = ws;

            while (ep < n) {
                sum = sum - nums.get(sp);
                sum = sum + nums.get(ep);
                if (sum > 0) {
                    ans = Math.min(ans, sum);
                }

                sp++;
                ep++;
            }

        }

        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}