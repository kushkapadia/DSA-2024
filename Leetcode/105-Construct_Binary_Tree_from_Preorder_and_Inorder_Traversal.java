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
    HashMap<Integer, Integer> map = new HashMap();

public TreeNode construct(int[] pre, int ps, int pe, int[] in, int is, int ie){
if(ps>pe || is>ie){
    return null;
}

TreeNode root = new TreeNode(pre[ps]);

int idx = map.get(pre[ps]);
int count = idx - is;

root.left = construct(pre, ps+1, ps+count ,in, is, idx-1); //when going to left, inorder start point always remains same. and end point is index -1 (index is the index of searched element)
root.right = construct(pre, ps+count+1, pe ,in, idx +1, ie); //when going to right, inorder start point always moves index +1 and end point remains same.

return root;

}
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i = 0; i<inorder.length; i++){
            map.put( inorder[i],i);
        }
       TreeNode ans =  construct(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1 );
       return ans;
    }
}