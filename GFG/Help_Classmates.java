//User function Template for Java

class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	    // Your code goes here

	   Stack<Integer> st = new Stack();
	   
	   int[] ans = new int[n];
	   
	   for(int i = 0; i< n; i++){
	       while(st.size() > 0 && arr[i] < arr[st.peek()] ){
	           int idx = st.pop();
	           ans[idx] = arr[i];
	       }
	       st.push(i);
	   }
	   
	   while(st.size()>0){
	       ans[st.pop()] = -1;
	   }
	   
	   return ans;
	   
	} 
}
