// User function Template for Java
class Solution {
    
      public static int calculate(int[] arr, int m){
        int cows = 1;
        int lastCowPositon = arr[0];
        
        for(int i =1; i< arr.length; i++){
            if( arr[i] - lastCowPositon >= m){
                lastCowPositon = arr[i];
                cows++;
            }
           
        }
        return cows;
    }
    
    
      public static int minConsecutiveDif(int[] arr){
       int minDif = Integer.MAX_VALUE;
        for(int i=0; i<arr.length-1; i++){
      
            if((arr[i+1] -arr[i]) < minDif ){
                minDif = (arr[i+1] -arr[i]);
            }
        }
        return minDif;
    }
    
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        
        Arrays.sort(stalls);
        int n = stalls.length;
        int ans=0;
        int low = minConsecutiveDif(stalls);
        int high = stalls[n-1] - stalls[0]; //sum of array
    
        while(low<= high){
            int m = (low+high)/2; //m resembles max distance
            
            int cowsPlaced = calculate(stalls, m);//
        
            if(cowsPlaced >= k){
                ans = m;
                low = m+1;
            } else{
                high = m-1;
            }
            
        }
        return ans;
    }
}