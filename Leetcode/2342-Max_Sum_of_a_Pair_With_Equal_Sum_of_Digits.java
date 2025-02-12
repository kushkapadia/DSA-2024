class Solution {

    public int sum(int num) {
        int sum = 0;

        while (num != 0) {
            int digit = num % 10;
            sum = sum + digit;
            num = num / 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            int sum = sum(nums[i]);

            if (map.containsKey(sum)) {
                int num = map.get(sum);
                ans = Math.max(ans, nums[i] + num);
                if (num > nums[i]) {
                    map.put(sum, num);
                } else {
                    map.put(sum, nums[i]);

                }
            } else {
                map.put(sum, nums[i]);
            }

        }

        return ans;
    }
}