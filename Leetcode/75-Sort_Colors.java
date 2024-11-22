class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int k = nums.length - 1;

        while (j <= k) {
            if (nums[j] == 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            } else if (nums[j] == 1) {
                j++;
            } else {
                int temp2 = nums[j];
                nums[j] = nums[k];
                nums[k] = temp2;
                k--;
            }
        }

    }
}

/* approach:
Algo: Dutch National Flag algo
(Can be upto 5 fixed numbers, in that case take 5 pointers)

simple logic
puit i an dj on oth index and k on last index

now,
0 - i-1 --> all 0s
i - j-1 --. all 1s
j - k --> all 2,s

to be solved part; j - k;
*/