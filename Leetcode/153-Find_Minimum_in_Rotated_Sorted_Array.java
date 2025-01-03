class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (ans == -1 || nums[mid] < nums[ans]) {
                ans = mid;
            }

            if (nums[mid] <= nums[high]) {
                // right part is sorted
                // if sorted the obviously the minimum amomngst the sorted will be the first
                // element.

                if (ans == -1 || nums[mid] < nums[ans]) {
                    ans = mid;
                }
                // now we will have to search in the unsorted, therefore move high
                high = mid - 1;
            } else {
                // left part is sorted

                if (ans == -1 || nums[low] < nums[ans]) {
                    ans = low;
                }
                // now we will have to search in the unsorted, therefore move low
                low = mid + 1;
            }

        }

        return nums[ans];
    }
}