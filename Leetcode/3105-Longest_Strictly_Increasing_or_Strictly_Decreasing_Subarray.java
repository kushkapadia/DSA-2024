class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1;

        for (int i = 0; i < nums.length; i++) { // start index
            for (int j = i; j < nums.length; j++) { // end index
                boolean isIncreasing = true;
                boolean isDecreasing = true;
                for (int k = i; k < j; k++) { // start to end
                    // all sub arrays

                    if (nums[k] >= nums[k + 1]) {
                        isIncreasing = false;
                    }
                    if (nums[k] <= nums[k + 1]) {
                        isDecreasing = false;
                    }
                }
                if (isIncreasing || isDecreasing) {
                        ans = Math.max(ans, j - i + 1);// end - start +1; = because inclusive
                    }

            }

        }

        return ans;
    }
}

// // 1
// // 14
// // 143
// // 1433
// // 14332
// // 4
// // 43
// // 433
// // 4332
// // 3
// // 33
// // 332
// // 3
// // 32
// // 2

// // 3,2,1
// // 3
// // 32
// // 321
// // 2
// // 21
// // 1



