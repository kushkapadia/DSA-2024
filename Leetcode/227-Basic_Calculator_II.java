class Solution {

    public int calc(int op1, int op2, char op) {
        if (op == '+') {
            return op1 + op2;
        } else if (op == '-') {
            return op1 - op2;
        } else if (op == '*') {
            return op1 * op2;
        } else {
            return op1 / op2;
        }
    }

    public int prec(char op) {
        if (op == '*' || op == '/') {
            return 1;
        } else {
            return 0;
        }
    }

    public int calculate(String s) {
        Stack<Integer> st = new Stack(); // stack to save operand
        Stack<Character> operators = new Stack(); // stack to save operators
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int num = 0;
                // the below while loop is to handle a longer input of number for eg: 1234, or
                // 56 etc.
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + (s.charAt(i) - '0'); // this combines the digits and gives a proper output.
                    i++;
                }
                st.push(num); // push the number into operand stack
                i--; // we will go on one index ahead than the number, therefore, bring it back to
                     // ensure proper execution.
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '/' || s.charAt(i) == '*') { // if it
                                                                                                               // is an
                                                                                                               // operator
                while (operators.size() > 0 && prec(operators.peek()) >= prec(s.charAt(i))) { // then check the
                                                                                              // precedence. iof the
                                                                                              // incoming has les prec,
                                                                                              // this means previous
                                                                                              // things in the stack can
                                                                                              // be solved
                    char op = operators.pop();
                    int val2 = st.pop();
                    int val1 = st.pop();

                    int cal = calc(val1, val2, op); // calculate the value
                    st.push(cal); // push the new value
                }
                operators.push(s.charAt(i)); // push the incoming operator

            }
            i++;
        }

        // there are chances that few operators are still left in the stack, keep poping
        // them and solve the values
        while (operators.size() > 0) {
            char op = operators.pop();
            int val2 = st.pop();
            int val1 = st.pop();

            int cal = calc(val1, val2, op);
            st.push(cal); // keep pushing new value.
        }
        return st.pop(); // the last value remaining will be our answer.
    }
}