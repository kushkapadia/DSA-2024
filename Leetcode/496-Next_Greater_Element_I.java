// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         int[] temp = new int[nums2.length];
//         int[] ans = new int[nums1.length];
//         Stack<Integer> st = new Stack();
//         Arrays.fill(temp, -1);
//         Arrays.fill(ans, -1);

//         for (int i = 0; i < nums2.length; i++) {
//             while (st.size() > 0 && nums2[i] > nums2[st.peek()]) {
//                 int idx = st.pop();
//                 temp[idx] = nums2[i];
//             }
//             st.push(i);
//         }
//         int k = 0;
//         for (int i = 0; i < nums1.length; i++) {
//             for (int j = 0; j < nums2.length; j++) {
//                 if (nums1[i] == nums2[j]) {
//                     ans[k] = temp[j];
//                     k++;
//                 }
//             }
//         }
//         return ans;
//     }
// }


import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums1.length];

        // Traverse nums2 and store the next greater element for each number
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Fill the result array using the precomputed next greater elements
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}
