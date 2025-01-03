class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;


//repeat until the error is 
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] <= nums[high]) {
                // we are in the right side of the array (right side is sorted)

                // check if target is in the range.
                if ((target >= nums[mid]) && (target <= nums[high])) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                // we are in the left side of the array. (left side is sorted)

                //check if number is on the range and shift the pointers accordingly.
                if ((target >= nums[low]) && (target <= nums[mid])) { 
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

        }

        return -1;
    }
}