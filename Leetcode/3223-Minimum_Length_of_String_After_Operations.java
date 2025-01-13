class Solution {
    public int minimumLength(String s) {

        if (s.length() <= 2) {
            return s.length();
        }
        int count = s.length();

        HashMap<Character, Integer> freq = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1); // Increment frequency

            if (freq.get(c) > 2) {
                int val = freq.get(c) / 3;
                count = count -2;
                freq.put(c, val);
            }
        }


        // for (char key : freq.keySet()) {

        //     count = count + freq.get(key);

        // }

        return count;
    }
}