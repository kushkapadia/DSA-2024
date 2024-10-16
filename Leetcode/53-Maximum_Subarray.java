class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i< nums.length; i++){
            if(sum>=0){
                sum = sum + nums[i];
            } else{
                sum = nums[i];
            }

            ans = Math.max(sum, ans);
        }
        return ans;
    }
}


//kadane's algo
//approach
//maintain sum and ans variables. Update sum only if previous value > 0, or else the current elemnt is the sum.
//update ans with the maximum value of the current answer and the current sum.
//return ans