class Solution {
    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);

        long total = 0;
        int maxfreq = 0;
        int r = 0;
        int l = 0;
        int n = nums.length;

        for (r = 0; r < n; r++) {
            total = total + nums[r];

          while ((long)nums[r] * (r - l + 1) - total > k){
                total = total-nums[l];
                l++;
            }
            maxfreq = Math.max(maxfreq, r-l+1 );
        }
        return maxfreq;
    }
}

// Sort the array and try to equalize all numbers in a window to the rightmost (largest) one. Keep the window only if the cost is within k. Maximize that window size.

//r-l+1 = length
//In this question, we are selecting the valus in the  range that can be changed and made equal. Hence length(that we are permittted to change based on the k) == our answer

//Brute force:
//Change every value and change.