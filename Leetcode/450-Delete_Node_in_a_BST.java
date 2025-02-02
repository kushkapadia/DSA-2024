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

// case 1: left and right are null (simply delete)
// case 2: left child exists, right is null. add left child to the left of the
// root.
// Case 3: right child exists, left is null. Add right child to the right of the
// root
// Case 4: Both children exists, replace its value with the maximum on the left
// or minimum on the right. And delete the max/min node.
class Solution {

    
    public int findMax(TreeNode root){
        while(root.right!=null){
            root = root.right;
        }
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int k) {
        
        if(root == null){
            return null;
        }

        if(k<root.val){
            //k is on left;
            root.left = deleteNode(root.left, k);
        } else if(k>root.val){
            root.right = deleteNode(root.right, k);
        } else{
            //root.val == k;
            //Now check the 4 cases.
            //case 1
            if(root.left == null && root.right == null){
                return null;
                //case 2:
            } else if(root.left!=null && root.right == null){
                return root.left; //left child exists, right is null. add left child to the left of the root. (adding part will be taken care by ' root.left = deleteNode(root.left, key); ' this line)
            } 
            //case 3:
            else if(root.left==null && root.right!=null){
                return root.right; //same logic as above;
            } else{
                //case 4;
                int max = findMax(root.left); //root.left because we have to find max on the left side;
                root.val = max;
                root.left = deleteNode(root.left, max); // this  deleteNode function will delete the max from the left subtree and retunr thr updated left subtree, we need to now replace the existing left subtree with the updated left subtree. Therefore we write root.left.
            }
        }

        return root;

    }
}