class Solution {
    public int countPalindromicSubsequence(String s) {
        HashMap<Character, Integer> firstOcc = new HashMap();
        HashMap<Character, Integer> lastOcc = new HashMap();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {

            if (!firstOcc.containsKey(s.charAt(i))) {
                firstOcc.put(s.charAt(i), i);
            }
            lastOcc.put(s.charAt(i), i);
        }

        for (char ch : firstOcc.keySet()) {
            int first = firstOcc.get(ch);
            int last = lastOcc.get(ch);

            HashSet<Character> hs = new HashSet();

            for (int i = first + 1; i < last; i++) {
                hs.add(s.charAt(i));
            }
            count = count + hs.size();
        }
        return count;
    }
}
// time: O(n)
// space: o(n)