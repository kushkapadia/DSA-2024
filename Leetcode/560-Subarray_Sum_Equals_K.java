// prefix sum with hashmap technique

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        int ans = 0; // total number of subarrays whose sum equals to k
        map.put(0, 1); // this is added to handle the case where prefix[end] == k, in those cases the
                       // diff will be 0, which means that there is an subarray whose sum is k;

        int[] prefixSum = new int[nums.length];

        // calculate prefix sum
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        // sum formula: prefixSum[end] - prefixSum[start-1] = k;
        // resuffle the formula to be: prefixSum[end] - k = prefixSum[start-1]
        for (int end = 0; end < nums.length; end++) {
            // difference is basically a start point(value, not the index) from where we are
            // getting a subarray till end whose sum is k;
            int diff = prefixSum[end] - k;

            // we are checking the frequncy of the value in the prefix array.
            // add the freq into ans
            ans = ans + map.getOrDefault(diff, 0);

            // add the value at index end into the hashmap (update the frequncy)
            map.put(prefixSum[end], map.getOrDefault(prefixSum[end], 0) + 1);
        }
        return ans;
    }
}

// Instead of using a nested loop (O(n²) brute force) to check all subarrays, we
// use a HashMap (O(n) solution).

