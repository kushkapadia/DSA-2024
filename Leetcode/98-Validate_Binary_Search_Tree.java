// // /**
// //  * Definition for a binary tree node.
// //  * public class TreeNode {
// //  * int val;
// //  * TreeNode left;
// //  * TreeNode right;
// //  * TreeNode() {}
// //  * TreeNode(int val) { this.val = val; }
// //  * TreeNode(int val, TreeNode left, TreeNode right) {
// //  * this.val = val;
// //  * this.left = left;
// //  * this.right = right;
// //  * }
// //  * }
// //  */
class Solution {

    public boolean isValid(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }
   long rval = root.val;
        boolean l = isValid(root.left, min, rval - 1);
        boolean r = isValid(root.right, rval + 1, max);

               if(l==false || r == false){
            return false;
        }
        return true;

    }

    public boolean isValidBST(TreeNode root) {
        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;
       return isValid(root, min, max);
    
    }
}



// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return isBST(root , Long.MIN_VALUE , Long.MAX_VALUE);
//     }
//     public boolean isBST(TreeNode root , long min , long max){
//         if(root == null) return true;
//         long rval = root.val;
//         if(rval<min || rval > max) return false;
        
//         boolean l = isBST(root.left ,min , rval-1);
//         boolean r = isBST(root.right ,rval+1 , max);
        
//         if(l==false || r == false){
//             return false;
//         }
//         return true;
//     }
// }



// Core Logic

// Whether the current node is within the allowed range (min and max).
// Recursively validate the left subtree with an updated max value (root.val - 1).
// Recursively validate the right subtree with an updated min value (root.val + 1).
// Base Case: Both return true for null nodes, as an empty tree is a valid BST.

// Use of Long: Both correctly use long to handle edge cases where Integer.MIN_VALUE or Integer.MAX_VALUE might be limiting.

// Return Statement: Both explicitly return false if any of the recursive checks fail.