class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        int n = s.length();
        int cs = (n / k);

        // i + cs
        // 2 + 2 = 4
        // 2<4 //2 3
        // aa bb cc
        // cs = 2. aa //2 i == 2
        HashMap<String, Integer> hm = new HashMap();

        for (int i = 0; i < n;) {
            int j = i;
            StringBuilder sb = new StringBuilder();
            for (j = i; j < i + cs; j++) {
                sb.append(s.charAt(j));
            }

            hm.put(sb.toString(), hm.getOrDefault(sb.toString(), 0) + 1);
            i = j;
        }

        // for target
        for (int i = 0; i < n;) {
            int j = i;
            StringBuilder sb = new StringBuilder();
            for (j = i; j < i + cs; j++) {
                sb.append(t.charAt(j));
            }
            i = j;
            if (hm.containsKey(sb.toString())) {
                if (hm.get(sb.toString()) == 1) {
                    hm.remove(sb.toString());
                } else {
                    hm.put(sb.toString(), hm.get(sb.toString()) - 1);
                }
            } else {
                return false;
            }
        }

        return true;
    }
}