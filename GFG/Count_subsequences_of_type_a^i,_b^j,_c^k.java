//User function Template for Java

class Solution
{
    public int fun(String s)
    {
        // Write your code here
        long ea = 0;
        long eb = 0;
        long ec = 0;
        long mod = 1000000007;
        //number of strings enbding with a,b,v respectively
        long n = s.length();
        
        for(int i = 0; i< n; i++){
            if(s.charAt(i) == 'a'){
                ea = (ea * 2 + 1) % mod; //a can be appended to all string that were previeoly ending with a, therefore it doubles. And + 1 because it cvan also stand as a standalone subsequence
            }  else if(s.charAt(i) == 'b' ){
                eb = (eb*2 + ea) % mod; //b can be appened to all string ending with b and also to all string ending with a
            } else{
                ec = (ec * 2 + eb) % mod; //c cann be appneded to all strings ending with c and also
            }
        }
        
        return (int) ec;
    }
}