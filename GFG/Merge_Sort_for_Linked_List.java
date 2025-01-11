/*
The structure of linked list is the following

class Node
{
int data;
Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    // Function to sort the given linked list using Merge Sort.
    

    static Node mergeSort(Node head) {
        // add your code here
        
        //be sure to include the base case
        
        //if theres is only 1 node in the list, then it will be sorted. therefore return the entire list.
         if(head.next == null){
            return head;
        }
        
        Node m =  mid(head);
        Node h2 = m.next;
        m.next = null;
        Node t1 = mergeSort(head); //divide untill theres only 1 node left
        Node t2 = mergeSort(h2); //divide untill there is only 1 node left
        
        Node ans = merge(t1, t2); //keep merging the lists.
        
        return ans;
        
    }
    
    static Node merge(Node h1, Node h2){
        Node ans;
        Node t;
        if(h1.data<h2.data){
            ans = h1;
            t = h1;
            h1 =h1.next;
        } else{
            ans = h2;
            t = h2;
            h2 =h2.next;
        }
        
        while(h1!=null && h2!=null){
            if(h1.data<h2.data){
                t.next = h1;
                t = t.next;
                h1 = h1.next;
            } else{
                 t.next = h2;
                t = t.next;
                h2 = h2.next;
            }
        }
        
        while(h1!=null){
            t.next = h1;
            t = t.next;
            h1 = h1.next;
        }
        
        while(h2!=null){
               t.next = h2;
            t = t.next;
            h2 = h2.next;
        }
        
        return ans;
    }
    
    static Node mid(Node h){
        //calculate mid usimng slow and fast pointer.
        
       
        Node slow = h;
        Node fast = h;
        
        
        //first check if fast.next !=null (I made a mistake on 11/1/25)
        while(fast.next !=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().mergeSort(head);
            printList(head);
        
System.out.println("~");
}
    }
}

