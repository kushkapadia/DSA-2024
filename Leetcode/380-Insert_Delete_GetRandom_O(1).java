class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> al;
    Random r;

    public RandomizedSet() {
        map = new HashMap();
        al = new ArrayList();
        r = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {

            map.put(val, al.size());
            al.add(val);

            return true;
        }
    }

    public boolean remove(int val) {

        // while removing from the AL, if u directly remove from the index, then all the
        // other elements perform shifting and then index wouldnt stay relative to those
        // saved in the map.
        // Therefore, swap the value at index to be deleted with the last elemnt, and
        // then remove last. In the hashmap only update the value of the last index.

        if (map.containsKey(val)) {

          
            // swap
            
        int idx = map.get(val);         // Index of the element to remove
        int lastIdx = al.size() - 1;    // Index of the last element
        int lastElement = al.get(lastIdx);

        // Swap val with the last element
        al.set(idx, lastElement);
        map.put(lastElement, idx);

        // Remove the last element
        al.remove(lastIdx);
        map.remove(val);

            return true;
        } else {
            return false;
        }

    }

    public int getRandom() {
        int idx = r.nextInt(0, al.size());
        return al.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */