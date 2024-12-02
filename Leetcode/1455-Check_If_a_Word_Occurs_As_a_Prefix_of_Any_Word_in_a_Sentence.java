class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int t = searchWord.length();
        int ans = -1;
        String arr[] = sentence.split(" ");

        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];

            if (s.length() < t) {
                continue;
            }

            int j = 0;
            while (j < t && s.charAt(j) == searchWord.charAt(j)) {

                j++;
            }

            if (j == t) {
                return i + 1;
            }
        }

        return -1;
    }
}