/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int ans = Integer.MIN_VALUE;
    
    int height(Node root){
        if(root == null){
            return -1;
        }
        
        int l = height(root.left);
        int r = height(root.right);
        
        int h = l + r +2;
        ans = Math.max(ans, h);
        return Math.max(l, r) +1;
    } 
    int diameter(Node root) {
        // Your code here
        height(root);
        return ans;
    }
}
