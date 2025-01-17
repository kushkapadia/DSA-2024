// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int n = arr.length;
        int[] prefixP = new int[n];
        // int prefixP = 1;
        // for(int i = 0; i< n; i++){
        //     prefixP= prefixP * arr[i];
        // }
       
        // int[] ans = new int[n];
        //  for(int i = 0; i< n; i++){
           
        //   ans[i] = (prefixP/arr[i]);
        
        
        //Note: The Above approach works, if the array has non zero elements, or else it gives divid byt zero error.
        
        //Idea 2:
        
        //Mantain a suffix variable. --> Thsi indicates the product of right side of the index
        
        prefixP[0] = arr[0];
         for(int i = 1; i<n; i++){
            prefixP[i] = prefixP[i-1] * arr[i]; //calculate prefix Product array.
        }


int suffix = 1;//signifies rhs product (if started from last index)
//eliminate the index that is consideres.

for(int i = n-1; i>0; i--){
     prefixP[i] =  prefixP[i-1] * suffix; //stores the product eliminating the current value.
     suffix = suffix * arr[i]; //update the suffix
}

prefixP[0] = suffix; //after the last itertion, suffix has the product of all elemnts on the right of 0th index. therefore directly store it in the 1st postion of ans arr;
       
       
        return prefixP;
        }
        
       
    }

