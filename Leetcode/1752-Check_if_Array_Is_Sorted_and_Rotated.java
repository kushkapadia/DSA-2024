class Solution {

    //mistake i made initially:
    //did not check the forst and the last elemnt.
    public boolean check(int[] nums) {
        boolean found = false;
        int n = nums.length;
        for (int i = nums.length; i > 0; i--) {
            // System.out.println(i + " " + (i-1));
            if (nums[i %n] < nums[i - 1]) {
                // System.out.println(i);
                if (found == true) {
                    return false;
                }
                found = true;
            }
        }
        return true;
    }
}


// class Solution {
//     public boolean check(int[] nums) {
//         boolean found = false;
//         int n = nums.length;
        
//         for (int i = 0; i < n; i++) {
//             // Compare current element with the next element, wrap around using modulo
//             if (nums[i] > nums[(i + 1) % n]) {
//                 // If it's the second occurrence of a break, return false
//                 if (found) {
//                     return false;
//                 }
//                 found = true;
//             }
//         }
        
//         // If we found at most one "break", the array is sorted and rotated
//         return true;
//     }
// }

//dry run on testcase
// 2>1 //true
// 1>3
// 3>4 
// 4>2 //true
