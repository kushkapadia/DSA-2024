class FreqStack {

    private HashMap<Integer, Stack<Integer>> map; // Map of frequency to a stack of numbers
    private HashMap<Integer, Integer> fMap; // Map of number to its frequency
    private int fmax; // Maximum frequency

    public FreqStack() {
        map = new HashMap<>();
        fMap = new HashMap<>();
        fmax = 0;
    }

    public void push(int val) {
        int f = fMap.getOrDefault(val, 0); //first, find value in the frequency map.
        f++; //update the frequency
        fMap.put(val, f); //put the updated value

        if (map.containsKey(f) == false) { //if the stack map does not contain the frequency
            map.put(f, new Stack<>()); //inistailise. a new stack, against that frequency
            fmax = Math.max(fmax, f); //update the max frequncy to the greater value.
        }

        map.get(f).add(val); //get the stack against the new frequncy and add the current value to it.
    }

    public int pop() {
        int val = map.get(fmax).pop(); //pop the elemnt from the stack against the highest freq.
        // reduce the frequency in the freq map
        int f = fMap.get(val);
        f--;
        fMap.put(val, f);

        if (map.get(fmax).size() == 0) {
            map.remove(fmax); //if stack size is 0, then also remove the key from the map.
            fmax--; //the max frequncy will decrement.
        }
        return val;
    }
}
/**
 * 
 * 2,8,2,4,24
 * 
 * 2 --> 1
 * 
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */