/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        while(true){
            if(p.val<root.val && q.val<root.val){ //if both node falls on the left of the node
                root = root.left; //then move the node to the left
            } else if(p.val>root.val && q.val>root.val){
                root = root.right; //else move right;
            } else{
                return root; //if it is equal or theres a split, then return the current root.
            }
        }
    }
}