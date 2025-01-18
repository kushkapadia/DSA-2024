class Solution {

    public boolean hasMatch(String s, String p) {
        String s1 = "";
        String s2 = "";

        int i = 0;

        while (p.charAt(i) != '*') {
            s1 = s1 + p.charAt(i);
            i++;
        }

        i++;

        while (i < p.length()) {
            s2 = s2 + p.charAt(i);
            i++;
        }

        int prefixIndex = s.indexOf(s1);
        if (prefixIndex == -1) {
            return false; // If prefix is not found, return false
        }

        // Find the remaining part of the string after the prefix
        int suffixStart = prefixIndex + s1.length();

        // Check if the remaining part contains the suffix
        return s.substring(suffixStart).contains(s2);

    }

}
