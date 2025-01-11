/*
  Merge two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Solution {
    // Function to merge two sorted linked list.
    Node sortedMerge(Node head1, Node head2) {
        // This is a "method-only" submission.
        // You only need to complete this method
        Node t;
        Node ans;
        if(head1.data<head2.data){
            t = head1;
            ans = head1;
            head1 = head1.next;
            
        } else{
              t = head2;
            ans = head2;
            head2 = head2.next;
        }
        
        while(head1 !=null && head2!=null){
            if(head1.data < head2.data){
                   t.next = head1;
                t = t.next;
                head1 = head1.next;
             
                
            } else{
                  t.next = head2;
                 t = t.next;
                head2 = head2.next;
              
            }
        }
        
        while(head1!=null){
  
            t.next = head1;
           t = t.next;
           head1 = head1.next;
        }
        
         while(head2!=null){
   
            t.next = head2;
          t = t.next;
           head2 = head2.next;
        }
        return ans;
    }
}
