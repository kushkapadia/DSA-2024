public class Solution {
    public int findDuplicate(int[] nums) {
        // Step 1: Find intersection point
      int slow = nums[0];
      int fast = nums[0];

      do{
        slow = nums[slow];
        fast = nums[nums[fast]];
      } while(slow != fast);

    slow = nums[0];
    while(slow!=fast){
        slow = nums[slow] ;
        fast = nums[fast];
    }

    return slow;
    }
}


// 1,3,4,2,2

// slow = 1;
// fast =1;

// slow = 3; //2
// fast = 2; //2

// slow = 1; //3
// fast = 2 //4