/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

/*Approach 
Time: O(n)
Space: O(1)
Step 1: Insertion:
Insert new nodes just after the original nodes
Step 2: Setting the random pointer.
--> for each new node set the random pointer to original +1;
Step 3: Seggregate 1 LL into 2 and return the latest one.
*/

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        // Insertion
        Node temp = head;
        // Node tempp1 = head.next;

        // insert a new node after every old node with same value
        // eg: OG list: 8,2,10,12
        // new list: 8,8,2,2,10,10,12,12

        while (temp != null) {
            Node n = new Node(temp.val);
            Node tempp1 = temp.next;

            temp.next = n;
            n.next = tempp1;

            temp = tempp1;
            // tempp1 = temp.next;
        }

        // Step 2: set random pointers.
        // as per the neew arrangment, the random pointer of the new nodes will point to
        // the next node of the node where the random pointer of the original node
        // pointed.
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

//step 3: Seggregation
//seggregate 2 lists.
        Node t1 = head;
        Node t2 = head.next;
        Node h2 = head.next;

        while (t1 != null) {
            Node t1p1 = t1.next.next; // always points orignal list
            Node t2p1 = null;
            if (t2.next != null) {
                t2p1 = t2.next.next; // this will always point new list.
            }
            t1.next = t1p1;
            t2.next = t2p1;

            t1 = t1p1;
            t2 = t2p1;

        }
        return h2;

    }
}