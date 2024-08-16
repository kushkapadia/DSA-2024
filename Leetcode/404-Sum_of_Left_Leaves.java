/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

public int sum(TreeNode root, TreeNode parent){
    if(root == null){
        return 0;
    }
    if(parent != null){
if(root.left == null && root.right == null && root == parent.left){
return root.val;
}
 int x = sum(root.left, root);
    int y = sum(root.right, root);
    return x+y;
    }
    else{
        int x = sum(root.left, root);
    int y = sum(root.right, root);
    return x+y;
    }
    
}

    public int sumOfLeftLeaves(TreeNode root) {
        
        int sum = sum(root, null);
        return sum;

    }
}