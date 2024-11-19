class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long sum = 0;
        long ans = 0;
        // Set for uniqueness
        HashMap<Integer, Integer> hm = new HashMap();
        // 1st Window
        int ws = k;
        int countDistinct = 0;
        boolean valid = true;
        for (int i = 0; i < ws; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);

            sum += nums[i];
            if (hm.get(nums[i]) > 1) {
                valid = false;
            } else {
                countDistinct++;
            }
        }
        if (valid) {
            ans = sum;
        }

        for (int i = k; i < n; i++) {
            // Remove i-k
            // Add i
            if (hm.get(nums[i - k]) == 1) {
                hm.remove(nums[i - k]);
                countDistinct--;
            } else {
                hm.put(nums[i - k], hm.get(nums[i - k]) - 1);
            }
            sum -= nums[i - k]; // release sum
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            if (hm.get(nums[i]) == 1) {
                countDistinct++;
            }

            sum += nums[i]; //acquire sum
            if (countDistinct == k) {
                ans = Math.max(sum, ans);
            }
        }

        return ans;
    }
}