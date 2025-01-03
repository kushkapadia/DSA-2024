class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] psum = new long[nums.length];
    int count = 0;
    psum[0] = nums[0];
        for(int i = 1; i<nums.length; i++){
            psum[i] = psum[i-1] + nums[i];
        }

        for(int i = 0; i< nums.length-1; i++){

            if(psum[i] >= (psum[nums.length-1] - psum[i] ) ){
                count++;
            }
        }
        return count;
    }
}

// [10,14,6, 13]