/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Intersect {
    // Function to find intersection point in Y shaped Linked Lists.
    static Node intersectPoint(Node head1, Node head2) {
        // code here
        
        int count1=0;
        int count2 =0;
        Node temp1 = head1;
        Node temp2 = head2;
        
        while(temp1!=null){
            count1++;
            temp1 = temp1.next;
        }
        
          while(temp2!=null){
            count2++;
            temp2 = temp2.next;
        }
        
        int diff= -1;
        
        if(count1>count2){
             diff = count1-count2;
              while(diff!=0){
                  head1 = head1.next;
                  diff--;
              }
        } else{
            diff = count2-count1;
               while(diff!=0){
                  head2 = head2.next;
                  diff--;
              }
        }
      
        
        while(head1!=null && head2!=null){
            if(head1 == head2){
                return head1;
            } else{
                head1= head1.next;
                head2 = head2.next;
            }
        }
        
        return null;
    }
}


/* Approach

Step 1: count numbner of nodes in list 1;
Step 2: Count number of nodes in list 2;
step 3: Calculate difference
Step 4: Jump the difference in longer list.
Step 5: Traverse both list untill a node matches.
Sopace: O(1);
Time: O(m+n);
*/