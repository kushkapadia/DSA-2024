class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
       
        ArrayList<Integer> ans = new ArrayList();
        for(int i = 0; i< n; i++){
             int sum = 0;
            for(int j = i; j<n; j++){
            sum = sum + nums[j];
   
            ans.add(sum);
            }
        }
 
Collections.sort(ans);
int sum = 0;
for(int i = left-1; i<right; i++){

sum = (sum+ ans.get(i)) % (1000000000+7);

}
System.out.println(sum);

return  sum;
    }
}