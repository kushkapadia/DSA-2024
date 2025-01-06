//Important Note: 
class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        
        Stack<Integer> st = new Stack();
        int n = arr.length;

        // Initialize an ArrayList with default values of -1
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(-1);
        }

        
        for(int i = 0; i< arr.length; i++){
            
            //check if the incoming is greater than that in the stack
            while( (st.size()>0) && (arr[i] > arr[st.peek()])) {
              int idx =   st.pop(); //if available, then solve for that index. hence pop the existing index
                ans.set(idx, arr[i] ); //The incoming is the answer for the existing index.
            }
            
            st.push(i); //add the incoming into the stack
            
        }
        
      
        
        return ans;
        
    }
}