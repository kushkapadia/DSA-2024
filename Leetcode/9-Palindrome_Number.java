class Solution {
    public boolean isPalindrome(int x) {
        // String str = String.valueOf(x);
    
        // int i = 0;
        // int j = str.length() -1;

        // while(i<j){
        //     if(str.charAt(i) != str.charAt(j)){
        //         return false;
        //     }
        //     i++;
        //     j--;
        // }

        // return true;

        //follow up;

        if(x < 0){
            return false;
        }
        int og = x;
int reversed = 0;

while(x!=0){
    int digit = x % 10;
    x = x/10;
    reversed = reversed * 10 + digit;
}
System.out.println(reversed);
return og == reversed;

    }
}