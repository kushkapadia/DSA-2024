class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap();
        HashMap<Character, Integer> map2 = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            if (map1.containsKey(c)) {
                map1.put(c, map1.getOrDefault(c, 0) - 1);
                if (map1.get(c) == 0) {
                    map1.remove(c);
                }
            } else {
                return false;
            }
        }

        if (map1.size() == 0) {

            return true;
        } else {
            return false;
        }
    }
}
