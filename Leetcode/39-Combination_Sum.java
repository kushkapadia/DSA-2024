class Solution {

    private void findCombinations(int ind, int[] arr, int target,  List<List<Integer>> ans, List<Integer> ds){
        if(ind == arr.length){
            if(target == 0){
                ans.add(new ArrayList<Integer>(ds));
            }
            return;
        }
//pic and non pick approach
        if(arr[ind] <= target){ //pick condition
            ds.add(arr[ind]); //add that elem in ds
            findCombinations(ind, arr, target - arr[ind], ans, ds); //keep index same
            ds.remove(ds.size()-1); //if controll here is here means, this recursuion is executed and we are backtracked  tp this line. Make sure to remove the eklement. (if control is here, mena sit cannot bring the solution so remove thw 1 extra elem that was added - refer striver if any doubt)
                }               

            findCombinations(ind +1 , arr, target, ans, ds); //no pick condition

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();

        findCombinations(0, candidates, target, ans, new ArrayList());
        return ans;
    }


}