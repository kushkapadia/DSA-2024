class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        boolean same = true;
        int max = Integer.MIN_VALUE;

        int elem = nums[0];
        for (int i = 0; i < n; i++) {
          if(elem != nums[i]  ){
            same = false;
          }
        }

        if(same == true){
            return nums.length;
        }

        for (int i = 0; i < n; i++) {
            if (max < nums[i]) {

                max = nums[i];
            }
        }

        int[] ansArr = new int[max + 1];
        for (int i = 0; i < n; i++) {
            int rangeStart = nums[i] - k;
            if (rangeStart <= 0) {
                ansArr[0]++;
            } else {
                ansArr[rangeStart]++;
            }
            int rangeEnd = nums[i] + k;
            if (rangeEnd >= max) {
                ansArr[max]--;
            } else {
                ansArr[(rangeEnd + 1)]--;
            }
        }

        // int[] prefixSum
        int curSum = ansArr[0];
        int maxSum = 0;

        for (int i = 1; i < ansArr.length; i++) {
            curSum = curSum + ansArr[i];
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;

    }
}