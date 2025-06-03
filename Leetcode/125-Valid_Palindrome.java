class Solution {
    public boolean isPalindrome(String s) {

        //2 pointers
        s = s.toLowerCase();
        s = s.toLowerCase();
        System.out.println(s);

        StringBuilder str = new StringBuilder();

        for(int k = 0; k< s.length(); k++){
            if( (s.charAt(k) >= 97 && s.charAt(k) <= 122) || (s.charAt(k) >= 48 && s.charAt(k) <= 57) ){
                str = str.append(s.charAt(k));
            }
        }

        s = str.toString();

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}



// class Solution {
//     public boolean isPalindrome(String s) {
//         int i = 0, j = s.length() - 1;
        
//         while (i < j) {
//             // Move i to next alphanumeric
//             while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
//                 i++;
//             }
//             // Move j to previous alphanumeric
//             while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
//                 j--;
//             }

//             if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
//                 return false;
//             }

//             i++;
//             j--;
//         }

//         return true;
//     }
// }
