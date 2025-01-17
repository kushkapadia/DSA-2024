//User function Template for Java



//User function Template for Java
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution
{ 
    //Function to convert binary tree into circular doubly linked list.
    
    void concat(Node h1, Node h2){
        Node t1 = h1.left; //in DLL to get the last node, never iterate. This is the right method
        Node t2 = h2.left;
        
        //pointer adjustments to combine the LLs;
        t1.right = h2; 
        h2.left =  t1;
        
        t2.right = h1;
        h1.left = t2;
    }
    
    
    Node bTreeToClist(Node root)
    {
        //base case
        if(root == null){
            return root;
        }
        //will return the head of the linkedlist
        Node l = bTreeToClist(root.left);
        Node r = bTreeToClist(root.right);
        
        root.left = root.right = root; //if. there is single root, then left and right (prev and next) pointer will point to itself. this line exceutes for all cases.
        
        if(l== null && r == null){
            return root;
        } else if(l==null && r!=null){
            concat(root, r);
            return root;
        } else if(l!=null && r== null){
            concat(l, root);
            return l; //beacuse l is the first linked list, therefore return head of the 1st linkedlist
        } else{
             concat(l, root);
              concat(l, r);
              return l;
        }

    }
    
}
    
