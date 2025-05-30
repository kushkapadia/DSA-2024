class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProduct = new int[n];

        prefixProduct[0] = nums[0];
        int suffix = 1;
        for (int i = 1; i < n; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i];
        }

        for (int i = n - 1; i > 0; i--) {
            prefixProduct[i] = prefixProduct[i - 1] * suffix; //all the multiplication before i
            suffix = suffix * nums[i];
        }
        prefixProduct[0] = suffix;

        return prefixProduct;
    }
}

// prefixProduct
// suffix =1;

// prefixProduct[i] = prefixProduct[i+1] * suffix
// suffix = suffix * nums[i];