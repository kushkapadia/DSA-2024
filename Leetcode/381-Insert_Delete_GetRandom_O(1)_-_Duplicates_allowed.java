class RandomizedCollection {

    HashMap<Integer, HashSet> map;
    ArrayList<Integer> list;
    Random r;

    public RandomizedCollection() {
        map = new HashMap();
        r = new Random();
        list = new ArrayList();
    }

    public boolean insert(int val) {
        HashSet<Integer> set;
        boolean flag;
        if (map.containsKey(val)) {

            set = map.get(val);
            flag = false;
        } else {
            set = new HashSet();
            flag = true;
        }

        set.add(list.size());
        map.put(val, set);
        list.add(val);
        return flag;
    }

    public boolean remove(int val) {
        if (map.containsKey(val) == true) {

            HashSet<Integer> set = map.get(val);

            int remIdx = -1;

            for (int x : set) {
                remIdx = x;
                break;
            }

            set.remove(remIdx);
            map.put(val, set);

            if (remIdx == list.size() - 1) {
                list.remove(list.size() - 1);
            } else {
                int idx2 = list.size() - 1;
                int lastElement = list.get(idx2);

                list.set(remIdx, lastElement);
              
                HashSet<Integer> s = map.get(lastElement);
                s.remove(idx2); // remove the old index of the lastElement
                s.add(remIdx);
                map.put(lastElement, s);
                  list.remove(idx2);

            }
            if (map.get(val).size() == 0) {
                map.remove(val);
            }

            return true;
        } else {
            return false;
        }
    }

// public boolean remove(int val) {
// if (!map.containsKey(val)) return false; // Value not in collection

// HashSet<Integer> set = map.get(val);
// int remIdx = set.iterator().next(); // Get an index from set
// set.remove(remIdx); // Remove that index from set

// if (set.isEmpty()) {
// map.remove(val); // Remove entry from map if no more occurrences
// }

// int lastIdx = list.size() - 1;
// if (remIdx != lastIdx) { // Only swap if removing a middle element
// int lastElement = list.get(lastIdx);
// list.set(remIdx, lastElement); // Move last element to removed index

// HashSet<Integer> lastSet = map.get(lastElement);
// lastSet.remove(lastIdx); // Remove last index reference
// lastSet.add(remIdx); // Update new index in set
// }

// list.remove(lastIdx); // Remove last element from list
// return true;
// }
    // public boolean remove(int val) {
    // if (map.containsKey(val)) {
    // HashSet<Integer> set = map.get(val);
    // int remIdx = -1;

    // for (int x : set) {
    // remIdx = x;
    // break;
    // }

    // set.remove(remIdx);

    // if (set.isEmpty()) {
    // map.remove(val);
    // } else {
    // map.put(val, set);
    // }

    // int lastIdx = list.size() - 1;
    // if (remIdx != lastIdx) { // Swap only if it's not the last element
    // int lastElement = list.get(lastIdx);
    // list.set(remIdx, lastElement);

    // HashSet<Integer> lastElementSet = map.get(lastElement);
    // lastElementSet.remove(lastIdx); // Remove old index of lastElement
    // lastElementSet.add(remIdx); // Update it with the new index
    // }

    // list.remove(lastIdx);
    // return true;
    // }
    // return false;
    // }

    public int getRandom() {
        int idx = r.nextInt(0, list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

//
// import java.util.*;

// class RandomizedCollection {

// HashMap<Integer, HashSet<Integer>> map; // Maps value to set of indices
// ArrayList<Integer> list; // Stores all values
// Random r;

// public RandomizedCollection() {
// map = new HashMap<>();
// list = new ArrayList<>();
// r = new Random();
// }

// public boolean insert(int val) {
// boolean exists = map.containsKey(val);
// map.putIfAbsent(val, new HashSet<>()); // Create set if it doesn't exist
// map.get(val).add(list.size()); // Store index of new element
// list.add(val);
// return !exists; // Return true if it was first time insertion
// }

// public boolean remove(int val) {
// if (!map.containsKey(val)) return false; // Value not in collection

// HashSet<Integer> set = map.get(val);
// int remIdx = set.iterator().next(); // Get an index from set
// set.remove(remIdx); // Remove that index from set

// if (set.isEmpty()) {
// map.remove(val); // Remove entry from map if no more occurrences
// }

// int lastIdx = list.size() - 1;
// if (remIdx != lastIdx) { // Only swap if removing a middle element
// int lastElement = list.get(lastIdx);
// list.set(remIdx, lastElement); // Move last element to removed index

// HashSet<Integer> lastSet = map.get(lastElement);
// lastSet.remove(lastIdx); // Remove last index reference
// lastSet.add(remIdx); // Update new index in set
// }

// list.remove(lastIdx); // Remove last element from list
// return true;
// }

// public int getRandom() {
// return list.get(r.nextInt(list.size())); // Retrieve random element
// }
// }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
