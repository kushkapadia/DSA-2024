class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        int amount = 0;
        prefixMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], height[i]);
        }

        suffixMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], height[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            int lb = prefixMax[i-1]; 
            int rb = suffixMax[i+1];
            int yb = Math.min(lb, rb);
            int contri = yb - height[i];
            if (contri > 0) {
                amount = amount + contri;
            }
        }
        return amount;

    }
}

// Approach
// 1. calculate prefixMax and suffixMax
// left blockage = prefixMax(i)
// right blockage= sufficMax(i)
// your blockage = min(l, r)
// contri = yb - height[i];