class Solution {
    public String addSpaces(String s, int[] spaces) {
        // StringBuilder sb = new StringBuilder(s);
        // // int offset = spaces[0];
        // for (int i = 0; i < spaces.length; i++) {

        // sb.insert(spaces[i], " ");
        // for (int j = 0; j < spaces.length; j++) {
        // spaces[j] = spaces[j] + 1;
        // }
        // }
        // return sb.toString();
        StringBuilder ans = new StringBuilder("");
        for (int i = 0; i < spaces.length; i++) {

            if (i == 0) {

                ans.append(s.substring(0, spaces[i])).append(" ");
            } else {
                ans.append(s.substring(spaces[i - 1], spaces[i])).append(" ");
                // ans = ans + s.substring(, spaces[i]) + " ";
            }
        }
        // ans = ans + s.substring( spaces[spaces.length-1], s.length()) ;
        ans.append(s.substring(spaces[spaces.length - 1], s.length()));

        return ans.toString();
    }
}