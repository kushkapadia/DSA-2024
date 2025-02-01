class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int j = n;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
        if (i % 2 == 0) {
        ans[i] = nums[k];
        k++;
        } else {
        // System.out.println(j);
        ans[i] = nums[j];
        j = j + 1;
        }

        }
        // int k = 0;
        // for (int i = 0; i < nums.length; i = i + 2) {
        //     ans[i] = nums[k];
        //     ans[i + 1] = nums[n + k];
        //     k++;
        // }
        return ans;
    }
}