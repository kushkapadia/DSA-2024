class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int res = 0;

        int n = nums1.length;

        if (n % 2 != 0) {
            for (int i = 0; i < nums2.length; i++) {
                res = res ^ nums2[i];
            }
        }

        int m = nums2.length;
        if (m % 2 != 0) {
            for (int i = 0; i < nums1.length; i++) {
                res = res ^ nums1[i];
            }
        }
        return res;
    }
}

/*
if nums1 * nums2
then each elemnt in nums1 will get xored nums.length times.
Therefore, if nums2.length is even then using property A^A = 0, all elemnts from nums1 will be cancelled out and wont contribute to the answer.

Similarly for nums2 and length of nums1;

*/