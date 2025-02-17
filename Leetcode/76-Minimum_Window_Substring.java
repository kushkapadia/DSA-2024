class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> smap = new HashMap();
        HashMap<Character, Integer> tmap = new HashMap();

        if (t.length() > s.length()) {
            return "";
        }

        // store the t string freq as it is
        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int ansLen = Integer.MAX_VALUE;
        int sp = 0;
        int ep = 0;
        int ansSp = -1;
        int ansEp = -1;
        int matchCount = 0;
        while (ep < s.length()) {

            if (matchCount == t.length()) {

                if (ep - sp < ansLen) {
                    ansLen = ep - sp; // string length but ep is exclusive. Dry run on a string to know why.
                    ansSp = sp;
                    ansEp = ep - 1;
                }

                // release the character at sp;
                smap.put(s.charAt(sp), smap.get(s.charAt(sp)) -1 );
                // check if we lost something useful
                if (smap.get(s.charAt(sp)) < tmap.getOrDefault(s.charAt(sp), 0)) {
                    matchCount--;
                }

                sp++;

            } else {
                // aquire
                smap.put(s.charAt(ep), smap.getOrDefault(s.charAt(ep), 0) + 1);
                // check if we got something intersting
                if (smap.get(s.charAt(ep)) <= tmap.getOrDefault(s.charAt(ep), 0)) {
                    matchCount++;
                }
                ep++;

            }

        }

        while (matchCount == t.length()) {
            if (ep - sp < ansLen) {
                ansLen = ep - sp; // string length but ep is exclusive. Dry run on a string to know why.
                ansSp = sp;
                ansEp = ep - 1;
            }

            // release the character at sp;
            smap.put(s.charAt(sp), smap.get(s.charAt(sp)) - 1);
            // check if we lost something useful
            if (smap.get(s.charAt(sp)) < tmap.getOrDefault(s.charAt(sp), 0)) {
                matchCount--;
            }

            sp++;
        }
        if(ansSp == -1){
            return "";
    }
        return s.substring(ansSp, ansEp + 1);
    }
}