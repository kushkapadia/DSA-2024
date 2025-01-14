
class Node {
    Node prev;
    int key;
    int val;
    Node next;
}

class LRUCache {

    HashMap<Integer, Node> hm;
    Node h = new Node();
    Node t = new Node();
    int capacity;

    public Node delete(Node d) {
        Node dm1 = d.prev;
        Node dp1 = d.next;
        dm1.next = dp1;
        dp1.prev = dm1;
        d.next = null;
        d.prev = null;

        return d;
    }

    public void add(Node h, Node t, Node n) {
        // Node tm1 = T.prev;
        // T.prev = n;
        // tm1.next = n;
        // n.next = T;

        Node tm1 = t.prev; // Node before tail
        t.prev = n; // Link new node before tail
        tm1.next = n; // Link the previous node to the new node
        n.prev = tm1; // Back-link the new node to the previous node
        n.next = t; // Forward-link the new node to the tail
    }

    public LRUCache(int capacity) {
        hm = new HashMap();
        h.next = t;
        t.prev = h;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!hm.containsKey(key)) {
            return -1;
        } else {
            int ans = hm.get(key).val;
            Node temp = delete(hm.get(key));
            add(h, t, temp);
            return ans;
        }
    }

    public void put(int key, int value) {
        Node res = hm.get(key);

        if (res == null) {
            if (hm.size() == capacity) {
                hm.remove(h.next.key);
                delete(h.next);
            }

            Node n1 = new Node();
            n1.key = key;
            n1.val = value;
            hm.put(key, n1);
            add(h, t, n1);
        } else {
            // already open app
            Node temp = delete(res);
            temp.val = value;
            hm.put(key, temp);
            add(h, t, temp);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */