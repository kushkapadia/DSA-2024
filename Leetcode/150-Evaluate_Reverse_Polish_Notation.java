class Solution {

    public int calc(int val1, int val2, String op) {
        if (op.equals("+")) {
            return val1 + val2;
        } else if (op.equals("*")) {
            return val1 * val2;
        } else if (op.equals("-")) {
            return val1 - val2;
        } else {
            return val1 / val2;
        }
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int val2 = st.pop();
                int val1 = st.pop();
                int cal = calc(val1, val2, tokens[i]);
                st.push(cal);
            } else {
                int num = Integer.parseInt(tokens[i]);
                st.push(num);
            }
        }
        return st.pop();
    }
}

// class Solution {

//     public int calc(int val1, int val2, String op) {
//         switch (op) {
//             case "+":
//                 return val1 + val2;
//             case "-":
//                 return val1 - val2;
//             case "*":
//                 return val1 * val2;
//             case "/":
//                 return val1 / val2; // Division always truncates toward zero
//             default:
//                 throw new IllegalArgumentException("Invalid operator");
//         }
//     }

//     public int evalRPN(String[] tokens) {
//         Stack<Integer> st = new Stack<>();

//         for (String token : tokens) {
//             // If the token is an operator, perform the operation
//             if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
//                 int val2 = st.pop();
//                 int val1 = st.pop();
//                 st.push(calc(val1, val2, token));
//             } else {
//                 // Otherwise, it must be a number, so push it onto the stack
//                 st.push(Integer.parseInt(token));
//             }
//         }

//         return st.pop(); // The result of the expression will be the last value in the stack
//     }
// }
