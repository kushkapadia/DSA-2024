/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    int greater = 0;

    // this is reverse inorder. Note: reverse inorder in BST will give us elements
    // in descending order.
    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.right);
        greater = greater + root.val; // startr from behind, there will be no elemen t larger than the last one,
                                      // therefore add 0 and update greater, keep on going in this way till the
                                      // smallest node.
        root.val = greater; // update the value of the node.
        helper(root.left);
    }

    public TreeNode bstToGst(TreeNode root) {
        helper(root);
        return root;
    }
}
