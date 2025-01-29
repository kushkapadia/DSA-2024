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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode temp = root;
        TreeNode n = new TreeNode(val);
        if (root == null) {
            root = n;
            return root;
        }
        while (true) {
            if (temp.val > val) {
                // go to left
                if (temp.left == null) {
                    temp.left = n;
                    return root;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == null) {
                    temp.right = n;
                    return root;
                } else {
                    temp = temp.right;
                }
            }
        }
        // return root;
    }
}