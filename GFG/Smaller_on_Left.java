//User function Template for Java
class Solution{
    static List<Integer> leftSmaller(int n, int arr[])
    {
        //code here
        Stack<Integer> st = new Stack();
        
        List<Integer> ans = new ArrayList<>(n);
        
         for (int i = 0; i < n; i++) {
            ans.add(-1);
        }
        
        for(int i = n-1; i>=0; i--){
            while( (st.size() > 0) && (arr[i] < arr[st.peek()]) ){
                int idx = st.pop();
                ans.set(idx, arr[i]);
            }
            st.push(i);
        }
        return ans;
    }
}