class Solution {

    public int gcd(int a, int b){
        if(a == 0){
            return b;
        }

        int ans = gcd(b % a, a);
        return ans;
    }

    public int subarrayGCD(int[] nums, int k) {
      
        int count = 0;
        for(int sp = 0; sp<nums.length; sp++){
              int ans = 0;
            for(int ep = sp; ep<nums.length; ep++){

                 ans = gcd(ans , nums[ep]);
                if(ans<k){
                    break;
                }
                    if(ans == k){
                        count++;
                    }
            }
        }

        return count;
    }
}

// approach
// calculate gcd of subarrays, if it is less than k, then break, because if gcd is less, it can never go up.
//else if it is equal to k, then increment the count.