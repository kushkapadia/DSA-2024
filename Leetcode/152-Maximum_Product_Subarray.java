class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int pfp = 1;
        int max1 = Integer.MIN_VALUE;

        int sfp = 1;
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (pfp == 0) {
                pfp = nums[i];
            } else {
                pfp = pfp * nums[i];
            }
            max1 = Math.max(max1, pfp);
        }

        for (int i = n - 1; i >= 0; i--) {
            if (sfp == 0) {
                sfp = nums[i];
            } else {
                sfp = sfp * nums[i];
            }
            max2 = Math.max(max2, sfp);
        }

        return Math.max(max1, max2);
    }
}
