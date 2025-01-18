// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  * int val;
//  * ListNode next;
//  * ListNode() {}
//  * ListNode(int val) { this.val = val; }
//  * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
class Solution {
    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
        }

        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;

        ListNode l = null;
        ListNode r = null;
        ListNode lm1 = null;
        int count = 1;
        int lc = 0;
        while (temp != null) {

            ListNode t = temp;
            if (count == left) {
                lm1 = t;
                lc = count;
                l = temp;
            }

            if (count == right) {
                r = temp;
            }

            if (l != null && r != null) {
                break;
            }
            count++;
            temp = temp.next;

        }

        int leftCounter = 1;
        temp = head;
        while (temp != null && leftCounter != lc) {
            lm1 = temp;
            temp = temp.next;
            leftCounter++;
        }

        ListNode rp1 = r.next;
        r.next = null;
        System.out.println(l.val);
        System.out.println(r.val);
        r = reverse(l);

        lm1.next = r;
        System.out.println("lm1" + lm1.val);
        l.next = rp1;
        System.out.println(l.val);
        System.out.println(r.val);
if(left == 1 && rp1 == null){
    return r;
}

if(left == 1){
    head = r;
}
        return head;

    }
}


//chat gpt
// class Solution {
//     public ListNode reverseBetween(ListNode head, int left, int right) {
//         // Edge case: if left == right, no need to reverse
//         if (left == right) return head;

//         // Initialize pointers
//         ListNode prev = null;   // Node before `left`
//         ListNode curr = head;  // Current node during traversal

//         // Move `curr` to the `left` position and set `prev` as the node before it
//         for (int i = 1; i < left; i++) {
//             prev = curr;
//             curr = curr.next;
//         }

//         // Mark the start and end of the sublist to reverse
//         ListNode start = curr;        // `left` node
//         ListNode end = curr;         

//         // Move `end` to the `right` position
//         for (int i = left; i < right; i++) {
//             end = end.next;
//         }

//         // Save the node after the reversed sublist
//         ListNode next = end.next;
//         end.next = null; // Temporarily detach the sublist

//         // Reverse the sublist
//         ListNode newStart = reverse(start);

//         // Reconnect the reversed sublist with the rest of the list
//         if (prev != null) {
//             prev.next = newStart; // Connect the node before `left` to the new start
//         } else {
//             head = newStart;      // Update the head if `left == 1`
//         }

//         start.next = next; // Connect the original `start` (now the end of reversed) to the next node

//         return head;
//     }

//     // Reverse function
//     public ListNode reverse(ListNode head) {
//         ListNode curr = head;
//         ListNode prev = null;

//         while (curr != null) {
//             ListNode temp = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = temp;
//         }

//         return prev;
//     }
// }


//approach 2 : chat gpt:

// class Solution {
//     public ListNode reverseBetween(ListNode head, int left, int right) {
//         // Dummy node to handle edge cases where left == 1
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;

//         ListNode prev = dummy; // Node before the left position

//         // Move `prev` to the node before `left`
//         for (int i = 1; i < left; i++) {
//             prev = prev.next;
//         }

//         // Start reversing the sublist
//         ListNode curr = prev.next; // Node at the `left` position
//         ListNode next;

//         // Reverse the sublist between `left` and `right`
//         for (int i = 0; i < right - left; i++) {
//             next = curr.next;
//             curr.next = next.next;
//             next.next = prev.next;
//             prev.next = next;
//         }

//         // Return the new head (dummy.next handles cases where left == 1)
//         return dummy.next;
//     }
// }
