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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        List<List<Integer>> ans = new ArrayList();
  if (root == null) return ans;
        q.add(root);

        while(q.size()>0){
            int n = q.size();
            ArrayList<Integer> levelList = new ArrayList();

            for(int i = 1; i <= n; i++){
                TreeNode temp = q.remove();

                levelList.add(temp.val);

                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }

            ans.add(levelList);
        }
            return ans;
    }
}