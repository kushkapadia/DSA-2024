class Solution {
    public int removeDuplicates(int[] nums) {

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        int count = i + 1;

        for (int k = i + 1; k < nums.length; k++) {
            nums[k] = '_';
        }
        return count;
    }
}

//Asked in enTeam.ai
//Couldn't solve.