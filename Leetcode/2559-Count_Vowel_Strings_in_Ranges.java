class Solution {

    public boolean checkVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }

        return false;
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        // int n = queries.length;
        // HashSet<Character> hs = new HashSet();
        // hs.add('a');
        // hs.add('e');
        // hs.add('i');
        // hs.add('o');
        // hs.add('u');

        // for (int i = 0; i < n; i++) {
        // int count = 0;
        // for (int j = queries[i][0]; j <= queries[i][1]; j++) {
        // if (checkVowel(words[j].charAt(0)) &&
        // checkVowel(words[j].charAt(words[j].length() - 1))) {
        // count++;
        // }
        // }
        // ans[i] = count;
        // }
        // return ans;
        // }
        // }

        // int n = words.length;
        // int m = queries.length;

        // int[] ans = new int[n];

        // for (int i = 0; i < n; i++) {
        // String vowel = words[i];

        // if (checkVowel(vowel.charAt(0)) && checkVowel(vowel.charAt(vowel.length() -
        // 1))) {
        // ans[i] = 1;
        // }
        // }

        // int[] res = new int[m];

        // for (int i = 0; i < m; i++) {
        // int a = queries[i][0];
        // int b = queries[i][1];

        // int sum = 0;
        // for (int j = a; j <= b; j++) {
        // sum += ans[j];
        // }

        // res[i] = sum;
        // }

        // return res;
        // }

        int n = words.length;
        int m = queries.length;
        int[] ans = new int[m];

        int[] prefixCount = new int[n];
        int count = 0;

        if (checkVowel(words[0].charAt(0)) && checkVowel(words[0].charAt(words[0].length() - 1))) {
            count++;
        }
        prefixCount[0] = count;
        for (int i = 1; i < n; i++) {
            count = 0;
            if (checkVowel(words[i].charAt(0)) && checkVowel(words[i].charAt(words[i].length() - 1))) {
                count++;
            }
            prefixCount[i] = prefixCount[i - 1] + count;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(prefixCount[i]);
        }


    for(int j = 0; j<m; j++){
        int li = queries[j][0];
        int ri =  queries[j][1];

    if(li == 0){
        ans[j] =  prefixCount[ri];
    } else{
        ans[j] = prefixCount[ri] - prefixCount[li-1];
    }
    }
     return ans;
}
}