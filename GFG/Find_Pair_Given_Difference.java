class Solution {
    public boolean findPair(int[] arr, int x) {
        // code here
        if(arr.length ==1){
            return false;
        }
        int n = arr.length;
        int i = 0;
        int j = 1;
        Arrays.sort(arr);
        
        while(i<n && j<n){
            if(i!=j && arr[j]-arr[i] == x){
                return true;
            }
            else if(arr[j]-arr[i] > x){
                i++;
            } else{
                j++;
            }
        }
        
        return false;
    }
}
