class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) //if the length is odd, return false. cause it cannot be balanced
            return false;
        Stack<Integer> stack = new Stack(); //stack to store all locked but only opening
        Stack<Integer> unlocked = new Stack(); //stack to store all unlocked.

        for (int i = 0; i < n; i++) {
            char state = locked.charAt(i);
            if (state == '0') {
                unlocked.push(i); //blind push if state is unlocked
            } else if (s.charAt(i) == '(') { //if opening + lockled
                stack.push(i); //push in stack
            } else { // locked and closing
                if (!stack.isEmpty()) { 
                    stack.pop(); //stack has only opening brackets. hence, if closing and locke is incoming then cancel off with the one in the stack.
                } else { //locked and closing and no existing bracket in stack
                    if (!unlocked.isEmpty()) {
                        unlocked.pop(); //flip the bracket in the stack
                    } else {
                        return false; //if none of the cases match then return.
                    }
                }
            }
        }

        while (!stack.isEmpty() && !unlocked.isEmpty() && stack.peek() < unlocked.peek()) {
            //if both stacks are not empty, and bracket order is mantained then cancel off by eliminating brackets from both stacks.
            stack.pop();
            unlocked.pop();
        }

        return (stack.isEmpty()); //if the main stack is empty, then the answer is solved else return false.
    }

}
