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
    TreeNode f;
    TreeNode s;
    TreeNode prev;

    // remember the concept of swapping the incorrect index in a sorted order.
    // convert the same logic in nodes.

    public void inorder(TreeNode curr) {
        if (curr == null) {
            return;
        }
        inorder(curr.left);
        // write main logic here;
        // using inprder, at this place if u print values, you wuill always get selemnts
        // in sorted order in BST.
        // Taking an advantage of thus we take 3 pointers, first, second and prev. First
        // and second resembles the nodes whose values are to be swapped.

        // for 1st incorrect entry
        if (prev != null && prev.val > curr.val && f == null) {
            f = prev;
            s = curr;

            // for second incorrect entry.
        } else if (prev != null && prev.val > curr.val && f != null) {
            s = curr;
        }

        // set the prev to current value.
        prev = curr;
        inorder(curr.right); // move to the next node
    }

    public void recoverTree(TreeNode root) {

        f = s = prev = null;
        inorder(root);

        // swap only the values, as the structure is to be kept same
        int temp = s.val;
        s.val = f.val;
        f.val = temp;
    }
}

// tc: O(N);
// sc: O(H);