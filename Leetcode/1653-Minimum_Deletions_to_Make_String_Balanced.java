class Solution {
    public int minimumDeletions(String s) {
        int ans = 0;
        int b = 0;

        for(char c: s.toCharArray()){
            if(c == 'b'){
                b++;
            }else{
                if(b>0){
                ans= ans+1;
                b--;
            }
            }
            
        }
        return ans;
    }
}