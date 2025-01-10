// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         Deque<Integer> dq = new LinkedList<>();
//         int n = nums.length;
//         int[] ans = new int[n - k + 1];
//         for (int i = 0; i < k; i++) {

//             while (dq.size() > 0 && nums[i] > dq.getLast()) {
//                 dq.removeLast();
//             }
//             dq.addLast(nums[i]);
//             ans[i] = dq.getFirst();

//             for (int j = k; j < n; j++) {
//                 // insert ith element and remove n-kth element;
//                 while (dq.size() > 0 && nums[j] > dq.getLast()) {
//                     dq.removeLast();
//                 }

//                 dq.addLast(nums[j]);

//                 if (dq.getFirst() == nums[j - k]) {
//                     dq.removeFirst();
//                 }

//                 if (i >= k - 1) {
//                 ans[i - k + 1] = nums[dq.getFirst()];
//             }
//             }
//         }
//         return ans;
//     }
// }



class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int [] ans = new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i<k; i++){
            while(deque.size() > 0 && deque.getLast() < nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
        }
        ans[0] = deque.getFirst();
        for(int i = k; i<n; i++){
            if(nums[i-k] == deque.getFirst()) deque.removeFirst();
            while(deque.size() > 0 && deque.getLast() < nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
            ans[i-k+1] = deque.getFirst();
            
        }
        return ans;
    }
}
