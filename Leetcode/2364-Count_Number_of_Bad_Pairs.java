class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Long, Long> map = new HashMap();
        long n = nums.length;
        long ans = (n * (n - 1)) / 2;
        for (int ep = 0; ep < nums.length; ep++) {
            long diff = nums[ep] - ep;

            if (map.containsKey(diff)) {
                ans = ans - map.get(diff);
            }
            map.put(diff, map.getOrDefault(diff, 0L) + 1);

        }
        return ans;
    }
}
// TC: O(n)
//SC: O(n)
//Brute: TC: O(n^2) //for every j traverse from 0 to j.
// nums[j] -j = nums[i] -i;
// total pairs: n(n*1)/2
