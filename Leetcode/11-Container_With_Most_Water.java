class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (i < j) {

            int amt = (j - i) * Math.min(height[i], height[j]); // width * minimum hight
            max = Math.max(amt, max);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }
}