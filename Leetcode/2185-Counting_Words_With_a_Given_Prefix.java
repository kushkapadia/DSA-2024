// class Solution {
//     public int prefixCount(String[] words, String pref) {
//         int count = 0;

//     for(int j = 0; j<words.length; j++){
//         boolean res = isPrefix(pref, words[j]); 
//         if(res){
//             count++;
//         }
//     }
//         return count;
//     }

//     boolean isPrefix(String pref, String word){
//         int n = pref.length();
//         int m = word.length();
//         int i = 0;
//         int j = 0;

// if(n>m){
//     return false;
// }

//         while(i<n && j<m){
//             if(pref.charAt(i) ==word.charAt(j)){
//                 i++;
//                 j++;
//             }else{
//                 break;
//             }
//         }

//         if(i == n){
//             return true;
//         } else{
//             return false;
//         }
//     }
// }


class Solution {
    public int prefixCount(String[] words, String pref) {
        int n = words.length;
        int m = pref.length();

        int count = 0;
        for(int i=0; i<n; i++){
            // String word = words[i];

            // if(m > word.length()) continue;

            // boolean flag = true;
            // for(int j=0; j<m; j++){
            //     if(word.charAt(j) != pref.charAt(j)){
            //         flag = false;
            //     }
            // }

            boolean temp = words[i].startsWith(pref);

            if(temp) count++;
        }

        return count;
    }
}