class Solution {
    public boolean checkparity(int num1, int num2){
        boolean r1 =false;
        boolean r2 =false;
        if(num1 %2 == 0){
            r1 = true;
        }
        if(num2%2==0){
            r2 =true;
        }

        if(r1 == r2){
            return false;
        } else{
            return true;
        }
    }
    public boolean isArraySpecial(int[] nums) {
        if(nums.length == 1 ){
            return true;
        }

        for(int i = 1; i<nums.length; i++){
            if(!checkparity(nums[i-1], nums[i])){
             return false;
            }
        }

        return true;
    }
}



//214
// i =1 && i == i-1
// 1 -0
// 2-1

// 3-2