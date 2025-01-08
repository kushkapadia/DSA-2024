//Same problem, can be solved using 2 stacks as well, but that requires O(n) time. This question has been solved in foundation.

class MinStack {
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<Long>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (st.size() == 0) { // if stac is empty
            min = val; // first value is min
            st.push((long) 0); // push 0 in stack. Why?: Because while poppiong will return removed + min. 0
                               // will not contribute, therefore put 0;
            return;
        }

        long diff = val - min; // calculayte diference
        st.push(diff); // psuh
        if (val < min) {
            min = val; // update the min
        }
    }

    public void pop() {
        long rem = st.pop();

        if (rem < 0) {
            min = min - rem; // if rem<0 them adding that value to min will give us the original array value.
            return;
        }

    }

    public int top() {
        long val = st.peek();

        if (val < 0) {
            return (int) min;
        } else {
            return (int) (min + val);
        }
    }

    public int getMin() {
        if (st.size() == 0) {
            return -1;
        } else {
            return (int) min;
        }

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */