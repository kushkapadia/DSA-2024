// User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        // code here
        if(node == null){
            return -1;
        }
        int l = height(node.left);
        int r = height(node.right);
        
        return Math.max(l, r) +1;
    }
}
