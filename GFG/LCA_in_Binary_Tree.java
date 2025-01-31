/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class Solution {
    // Function to return the lowest common ancestor in a Binary Tree.
    Node lca(Node root, int n1, int n2) {
        // Your code here
        if(root == null){
            return null;
        }
        
        //return any node that matches
        if(root.data == n1 || root.data == n2){
            return root;
        }
        
        
      Node l = lca(root.left, n1, n2); //check on left
        
       Node r = lca(root.right, n1, n2); //check on right
       
       //this will occur only and only once (at most)
       //if both are non null, then keep returning that root, as that is the answer
       if(l!=null && r!=null){
           return root; //this is the answer
           
       } 
       //if both fall on the same path, then we will get our answer using the below conditions (edge case)
       
    //   normally, return the root, that is not null
       else if(l!=null){
           return l;
       } else{
           return r;
       }
    }
}
