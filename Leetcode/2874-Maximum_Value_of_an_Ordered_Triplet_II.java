class Solution {
    public long maximumTripletValue(int[] nums) {
        long max_diff = 0;
        long ans = 0;
        long left_max = 0;

        for(int i = 0; i<nums.length; i++){
            ans = Math.max(ans, max_diff * nums[i] );
            left_max = Math.max( left_max, nums[i] );
            max_diff = Math.max(max_diff,   left_max - nums[i] );
        }
        return ans;
    }
}

// https://youtu.be/qzJJdIZGjfA?si=K5ZVg3LIG7KIUt5g